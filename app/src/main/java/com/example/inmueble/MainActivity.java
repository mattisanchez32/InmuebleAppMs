package com.example.inmueble;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText email, contrasenia;

    Button ingresar;
    MainViewModel lvm;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurarVista();
        lvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);

    }
    private void configurarVista(){
        email = findViewById(R.id.editTextEmail);
        contrasenia = findViewById(R.id.editTextPass);
        ingresar = findViewById(R.id.btnIngresar);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvm.validar(email.getText().toString(), contrasenia.getText().toString());
            }
        });
    }
}
