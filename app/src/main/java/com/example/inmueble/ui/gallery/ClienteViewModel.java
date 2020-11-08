package com.example.inmueble.ui.gallery;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmueble.Inmueble;
import com.example.inmueble.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteViewModel extends AndroidViewModel {

    private MutableLiveData<Inmueble> inmuebleMutableLiveData;
    private MutableLiveData<Boolean> estado;
    private  MutableLiveData<String> textoBoton;
    private boolean alquilada;



    private Context context;


    public ClienteViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<Inmueble> getInmueble(){
        if(inmuebleMutableLiveData == null) {
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }



    public LiveData<Boolean> getEstado(){
        if(estado == null) {
            estado = new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton(){
        if(textoBoton == null) {
            textoBoton = new MutableLiveData<>();
        }
        return textoBoton;
    }

    public void rellenar(Inmueble inm){
        List<String> listaTipos = new ArrayList<>();
        Inmueble inm1;
        inm1 = inm;
        inmuebleMutableLiveData.setValue(inm);
        estado.setValue(false);

        alquilada = !inm.isDisponible();

    }

    public void editar(){
        if(estado.getValue() && alquilada){
            textoBoton.setValue("Guardar");
        }else{
            textoBoton.setValue("Editar");
        }
        if(!alquilada){
            Toast.makeText(getApplication().getApplicationContext(), "Propiedad reservada en este momento" , Toast.LENGTH_LONG).show();

            estado.setValue(false);
        }
    }


    public void guardar(Inmueble inm){
        if(estado.getValue() && alquilada){
            SharedPreferences pref = context.getSharedPreferences("token", 0);
            String t = pref.getString("token", "");

            Call<Inmueble> inmuebleActualizado = ApiClient.getMyApiClient().editarInmueble(t, inm.getIdInmueble(), inm);
            inmuebleActualizado.enqueue(new Callback<Inmueble>() {
                @Override
                public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                    if(response.isSuccessful()){
                        inmuebleMutableLiveData.setValue(response.body());
                        textoBoton.setValue("Editar");
                        estado.setValue(false);
                        Toast.makeText(getApplication().getApplicationContext(), "Propiedad Reservada" , Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onFailure(Call<Inmueble> call, Throwable t) {

                }
            });

        }else{
            estado.setValue(true);
        }
    }
}
