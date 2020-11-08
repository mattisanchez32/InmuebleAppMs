package com.example.inmueble.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.inmueble.Inquilinos;
import com.example.inmueble.ListaInquilinosAdapter;
import com.example.inmueble.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private ArrayList<Inquilinos> lista = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_slideshow, container, false);

        cargarDatos();
        ArrayAdapter<Inquilinos> adapter= new ListaInquilinosAdapter(getContext(),R.layout.iteminquilino,lista,getLayoutInflater());
        ListView lv = root.findViewById(R.id.lvInquilino);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Toast.makeText(getContext(),"es un texto",Toast.LENGTH_LONG).show();
                }

            }
        });



        return root;
    }

    public void generarListView(){

        ArrayAdapter<Inquilinos> adapter= new ListaInquilinosAdapter(getContext(),R.layout.iteminquilino,lista,getLayoutInflater());

    }

    public void cargarDatos(){
        lista.add(new Inquilinos(1,"juan","perez","barrio lala",2664, 123, "asdf@gmail.com"));
        lista.add(new Inquilinos(3,"pedro","lopez","barrio lala",2664,123, "asdf@gmail.com"));
        lista.add(new Inquilinos(2,"alberto","guzman","barrio lala",2664,123, "asdf@gmail.com"));
    }
}