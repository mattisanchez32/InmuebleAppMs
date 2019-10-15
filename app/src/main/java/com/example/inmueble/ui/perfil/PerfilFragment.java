package com.example.inmueble.ui.perfil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inmueble.EditarPerfilFragment;
import com.example.inmueble.MainActivity;
import com.example.inmueble.R;


public class PerfilFragment extends Fragment {


    EditText dni,apellido,nombre,telefono,email,pass;
    Button btnEditarPerfil;



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

        dni.setText(String.valueOf(MainActivity.prop.getPassword()));
        apellido.setText(String.valueOf(MainActivity.prop.getApellido()));
        nombre.setText(String.valueOf(MainActivity.prop.getNombre()));
        telefono.setText(String.valueOf(MainActivity.prop.getTelefono()));
        email.setText(String.valueOf(MainActivity.prop.getEmail()));
        pass.setText(String.valueOf(MainActivity.prop.getPassword()));

        btnEditarPerfil = root.findViewById(R.id.btnEditarPerfil);

        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.editarPerfilFragment);
                /*I7ntent intentEditar = new Intent(getContext(), EditarPerfilFragment.class);
                PerfilFragment.this.startActivity(intentEditar);*/
            }
        });

        return root;
    }








}
