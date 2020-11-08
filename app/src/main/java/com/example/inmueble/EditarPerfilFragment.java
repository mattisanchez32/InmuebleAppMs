package com.example.inmueble;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EditarPerfilFragment extends Fragment {


    EditText dni,apellido,nombre,telefono,email,pass;
    Button btnAceptar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_editar_perfil, container, false);

        dni = root.findViewById(R.id.etdni);
        apellido = root.findViewById(R.id.etApe);
        nombre = root.findViewById(R.id.etNom);
        telefono = root.findViewById(R.id.etTel);
        email = root.findViewById(R.id.etEma);
        pass = root.findViewById(R.id.etPass);

        /*dni.setText(String.valueOf(MainActivity.prop.getClave()));
        apellido.setText(String.valueOf(MainActivity.prop.getApellido()));
        nombre.setText(String.valueOf(MainActivity.prop.getNombre()));
        telefono.setText(String.valueOf(MainActivity.prop.getTelefono()));
        email.setText(String.valueOf(MainActivity.prop.getUsuario()));
        pass.setText(String.valueOf(MainActivity.prop.getClave()));*/



        return root;
    }








}
