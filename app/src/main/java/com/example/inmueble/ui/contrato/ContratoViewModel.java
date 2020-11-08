package com.example.inmueble.ui.contrato;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

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

public class ContratoViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> listaDirecciones;
    private Context context;


    public ContratoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<String>> getListaDirecciones(){
        if(listaDirecciones == null) {
            listaDirecciones = new MutableLiveData<>();
        }
        return listaDirecciones;
    }

    public void cargarDatos(){
        SharedPreferences pref = context.getSharedPreferences("token", 0);
        String t = pref.getString("token", "");

        Call<List<Inmueble>> listaInmuebles= ApiClient.getMyApiClient().listarInmuebles(t);
        listaInmuebles.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    ArrayList<String> lista = new ArrayList<>();
                    for (Inmueble i: response.body()) {
                        lista.add(i.getDireccion());
                    }
                    listaDirecciones.setValue(lista);
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {

            }
        });

    }


}
