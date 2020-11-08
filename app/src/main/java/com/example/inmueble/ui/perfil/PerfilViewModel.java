package com.example.inmueble.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmueble.Propietarios;
import com.example.inmueble.Usuario;
import com.example.inmueble.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {



    private Context context;
    private MutableLiveData<Propietarios> propietarioMutableLiveData;
    private MutableLiveData<String> mText;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Propietarios> getPropietarioMutableLiveData(){
        if(propietarioMutableLiveData==null){
            propietarioMutableLiveData=new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }



    public void leer(){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken = sp.getString("token","");
        Call<Propietarios> propietarioCall = ApiClient.getMyApiClient().leer(accessToken);

        propietarioCall.enqueue(new Callback<Propietarios>() {
            @Override
            public void onResponse(Call<Propietarios> call, Response<Propietarios> response) {

                if (response.isSuccessful()){
                    Propietarios propietarios = response.body();
                    propietarioMutableLiveData.postValue(propietarios);
                }
            }

            @Override
            public void onFailure(Call<Propietarios> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }






    public void actualizar(Propietarios propietarios){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");

        Call<Propietarios> proActualizado = ApiClient.getMyApiClient().actualizar(accessToken,propietarios);
        proActualizado.enqueue(new Callback<Propietarios>() {
            @Override
            public void onResponse(Call<Propietarios> call, Response<Propietarios> response) {
                Log.d("salida","por actualizar");
                if(response.isSuccessful()) {
                    propietarioMutableLiveData.postValue(response.body());
                    Toast.makeText(getApplication(), "Propietario Actualizado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietarios> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



}