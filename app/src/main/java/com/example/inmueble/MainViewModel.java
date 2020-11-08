package com.example.inmueble;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.inmueble.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {

    private Context contexto;

    public MainViewModel(@NonNull Application application) {
        super(application);
        contexto = getApplication().getApplicationContext();
    }





    public void validar(String email, String clave) {

        //Usuario u = new Usuario();
        //u.setClave(clave);
        //u.setUsuario(email);
        Call<String> token = ApiClient.getMyApiClient().login(email, clave);
        token.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    SharedPreferences pref= contexto.getSharedPreferences("token",0);
                    SharedPreferences.Editor editor= pref.edit();
                    String t = "Bearer "+response.body();
                    editor.putString("token",t);
                    editor.commit();

                    Intent i = new Intent(getApplication().getApplicationContext(), NavigationDrawerActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplication().startActivity(i);
                }else {
                    Toast.makeText(getApplication().getApplicationContext(), "Clave o Contraseña Incorrecta" , Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplication().getApplicationContext(), t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }
}



