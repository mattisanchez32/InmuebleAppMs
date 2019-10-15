package com.example.inmueble.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmueble.Inquilino;
import com.example.inmueble.ListaInquilinosAdapter;
import com.example.inmueble.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private ArrayList<Inquilino> lista = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_slideshow, container, false);

        cargarDatos();
        ArrayAdapter<Inquilino> adapter= new ListaInquilinosAdapter(getContext(),R.layout.iteminquilino,lista,getLayoutInflater());
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

        ArrayAdapter<Inquilino> adapter= new ListaInquilinosAdapter(getContext(),R.layout.iteminquilino,lista,getLayoutInflater());

    }

    public void cargarDatos(){
        lista.add(new Inquilino(323423,"juan","perez","barrio lala",2664));
        lista.add(new Inquilino(32342323,"pedro","lopez","barrio lala",2664));
        lista.add(new Inquilino(3234253,"alberto","guzman","barrio lala",2664));
    }
}