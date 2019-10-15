package com.example.inmueble;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ContratoFragment extends Fragment {


    private ExpandableListView expandableListView;
    private ListaContratosAdapter listaContratosAdapter;
    private ArrayList<String> listaInmueble = new ArrayList<>();
    private Map<String,ArrayList<Alquiler>> mapContrato = new HashMap<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contrato, container, false);

        expandableListView = root.findViewById(R.id.expContratos);
        cargarDatos();
        listaContratosAdapter = new ListaContratosAdapter(listaInmueble,mapContrato,getContext());
        expandableListView.setAdapter(listaContratosAdapter);

        return root;

    }

    private void cargarDatos(){
        listaInmueble.add("San Martin 300");
        listaInmueble.add("Ayacucho 300");
        listaInmueble.add("Lafinur 300");
        listaInmueble.add("España 300");

        ArrayList<Alquiler> sanMartin = new ArrayList<>();
        ArrayList<Alquiler> ayacucho = new ArrayList<>();
        ArrayList<Alquiler> lafinur = new ArrayList<>();
        ArrayList<Alquiler> espania = new ArrayList<>();

        sanMartin.add(new Alquiler("09-05-2018","09-12-2018",123));
        sanMartin.add(new Alquiler("15-03-2018","15-12-2018",123));
        sanMartin.add(new Alquiler("28-06-2018","28-12-2018",123));


        ayacucho.add(new Alquiler("23-11-2018","23-01-2019",1232));
        ayacucho.add(new Alquiler("15-02-2018","15-02-2019",1235));
        ayacucho.add(new Alquiler("28-03-2018","28-03-2019",1236));

        lafinur.add(new Alquiler("09-12-2017","09-12-2018",123));
        lafinur.add(new Alquiler("15-12-2017","15-12-2018",123));
        lafinur.add(new Alquiler("28-12-2017","28-12-2018",123));

        espania.add(new Alquiler("09-12-2017","09-12-2018",123));
        espania.add(new Alquiler("15-12-2017","15-12-2018",123));

        mapContrato.put(listaInmueble.get(0),sanMartin);
        mapContrato.put(listaInmueble.get(1),ayacucho);
        mapContrato.put(listaInmueble.get(2),lafinur);
        mapContrato.put(listaInmueble.get(3),espania);

    }








}
