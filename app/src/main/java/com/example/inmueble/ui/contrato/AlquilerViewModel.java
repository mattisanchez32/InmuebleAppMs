package com.example.inmueble.ui.contrato;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmueble.Alquiler;
import com.example.inmueble.ListContratoAdapter;
import com.example.inmueble.R;
import com.example.inmueble.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlquilerViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayAdapter<Alquiler>> adapterMutableLiveData;
     private Context contexto;

    public AlquilerViewModel(@NonNull Application application) {
        super(application);
        contexto= application.getApplicationContext();
    }


    public LiveData<ArrayAdapter<Alquiler>> getAdapter(){
        if(adapterMutableLiveData == null) {
            adapterMutableLiveData = new MutableLiveData<>();
        }
        return adapterMutableLiveData;
    }


    public void cargarDatos(final LayoutInflater li){
        SharedPreferences pref = contexto.getSharedPreferences("token", 0);
        String t = pref.getString("token", "");

        final Call<ArrayList<Alquiler>> contratostoken= ApiClient.getMyApiClient().obtenerAlquiler(t);

        contratostoken.enqueue(new Callback<ArrayList<Alquiler>>() {
            @Override
            public void onResponse(Call<ArrayList<Alquiler>> call, Response<ArrayList<Alquiler>> response) {
                    if(response.isSuccessful()){
                        ArrayList<Alquiler> lista = new ArrayList<>();
                        for (Alquiler a: response.body()){

                                    lista.add(a);
                                

                        }
                        ArrayAdapter<Alquiler> adapter = new ListContratoAdapter(getApplication().getApplicationContext(), R.layout.contrato_item_fragment, lista, li);
                        adapterMutableLiveData.setValue(adapter);
                    }
            }

            @Override
            public void onFailure(Call<ArrayList<Alquiler>> call, Throwable t) {

            }
        });


    }
    // TODO: Implement the ViewModel
}