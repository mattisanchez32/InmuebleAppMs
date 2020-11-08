package com.example.inmueble.ui.perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inmueble.MainActivity;
import com.example.inmueble.NavigationDrawerActivity;
import com.example.inmueble.Propietarios;
import com.example.inmueble.R;


public class PerfilFragment extends Fragment {








    EditText  dni,apellido,nombre,telefono,email,pass;
    Button btnEditarPerfil, btnGuardarPerfil;
    private PerfilViewModel perfilViewModel;
    private Propietarios propietariosVisto =null;


    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);


        dni = root.findViewById(R.id.etdni);
        apellido = root.findViewById(R.id.etApe);
        nombre = root.findViewById(R.id.etNom);
        telefono = root.findViewById(R.id.etTel);
        email = root.findViewById(R.id.etEma);
        pass = root.findViewById(R.id.etPass);



        btnEditarPerfil = root.findViewById(R.id.btnEditarPerfil);
        btnGuardarPerfil = root.findViewById(R.id.btnGuardarPerfil);

        perfilViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);


        perfilViewModel.leer();

        perfilViewModel.getPropietarioMutableLiveData().observe(this, new Observer<Propietarios>() {
            @Override
            public void onChanged(Propietarios propietarios) {
                propietariosVisto = propietarios;
                fijarDatos(propietarios);
            }
        });



        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar();
            }
        });


        btnGuardarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aceptar();
            }
        });

        return root;
    }

    public void editar(){
        dni.setEnabled(true);
        apellido.setEnabled(true);
        nombre.setEnabled(true);
        telefono.setEnabled(true);
        email.setEnabled(true);
        //pass.setEnabled(true);

        btnEditarPerfil.setVisibility(View.GONE);
        btnGuardarPerfil.setVisibility(View.VISIBLE);
    }

    public void aceptar(){

        propietariosVisto.setIdPropietario(propietariosVisto.getIdPropietario());
        propietariosVisto.setDni(Integer.parseInt(dni.getText().toString()));
        propietariosVisto.setApellido(apellido.getText().toString());
        propietariosVisto.setNombre(nombre.getText().toString());
        propietariosVisto.setTelefono(Integer.parseInt(telefono.getText().toString()));
        propietariosVisto.setEmail(email.getText().toString());
        propietariosVisto.setClave(pass.getText().toString());
        perfilViewModel.actualizar(propietariosVisto);
    }

    public void fijarDatos(Propietarios sesion){

        dni.setText(String.valueOf(sesion.getDni()));
        apellido.setText(String.valueOf(sesion.getApellido()));
        nombre.setText(String.valueOf(sesion.getNombre()));
        telefono.setText(String.valueOf(sesion.getTelefono()));
        email.setText(String.valueOf(sesion.getEmail()));
        pass.setText(String.valueOf(sesion.getClave()));
        Log.d("salida",pass.getText()+"");

        dni.setEnabled(false);
        apellido.setEnabled(false);
        nombre.setEnabled(false);
        telefono.setEnabled(false);
        email.setEnabled(false);
        //pass.setEnabled(false);

        btnEditarPerfil.setVisibility(View.VISIBLE);
        btnGuardarPerfil.setVisibility(View.GONE);

    }











}
