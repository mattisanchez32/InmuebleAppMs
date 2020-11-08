package com.example.inmueble.request;

import android.util.Log;

import com.example.inmueble.Alquiler;
import com.example.inmueble.Inmueble;
import com.example.inmueble.Propietarios;
import com.example.inmueble.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
        private static final String PATH="http://192.168.0.106:45455/api/";
        private static  MyApiInterface myApiInteface;
        private static String accessToken=null;


        public static MyApiInterface getMyApiClient(){


        Gson gson = new GsonBuilder().setLenient().create();
        //OkHttpClient.Builder client = new OkHttpClient.Builder();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                //.client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
        }


    public interface MyApiInterface {

        @FormUrlEncoded
        @POST("Propietarios/login")
        Call<String> login(@Field("Usuario") String usuario, @Field("Clave") String clave);

        @GET("Propietarios")
        Call<Propietarios> leer (@Header("Authorization")String token);

        @GET("Propietarios")
        Call<Propietarios> obtenerPropietario(@Header("Authorization")String token);

        @PUT("Propietarios")
        Call<Propietarios> actualizar(@Header("Authorization")String token, @Body Propietarios p);

        @GET("Inmueble")
        Call<List<Inmueble>> listarInmuebles(@Header("Authorization") String token);

        @PUT("Inmueble/{id}")
        Call<Inmueble> editarInmueble(@Header("Authorization") String token, @Path("id") int id, @Body Inmueble i);

        @GET("Alquiler")
        Call<ArrayList <Alquiler>> obtenerAlquiler(@Header("Authorization")String token);






        //@FormUrlEncoded
        //@PUT("Propietarios/{id}")
        //Call<Propietarios> actualizar(@Header("Authorization")String token, @Path("id") int groupId, @Field("Apellido")String apellido, @Field("Nombre")String nombre, @Field("Email")String email, @Field("Telefono")int telefono, @Field("Dni") int dni, @Field("Clave")String clave);




    }
}
