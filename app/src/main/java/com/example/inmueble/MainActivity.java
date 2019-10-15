package com.example.inmueble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText email,contra;
    private Button btnIngresar,btnRegistrar;
    public static Propietario prop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.editTextEmail);
        contra = findViewById(R.id.editTextPass);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrarse);
        prop = new Propietario("Lopez","juan", 123123,"barrio 1",123123,"juancito@gmail.com","1234");


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((email.getText().toString().equals(prop.getEmail())&&(contra.getText().toString().equals(prop.getPassword())))) {
                    Intent intentIngresar = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                    MainActivity.this.startActivity(intentIngresar);
                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña Incorrecta",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnRegistrar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistrar = new Intent(MainActivity.this,RegistarActivity.class);
                MainActivity.this.startActivity(intentRegistrar);
            }
        }));
    }
}
