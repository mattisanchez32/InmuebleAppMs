package com.example.inmueble.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmueble.ListaPagosAdapter;
import com.example.inmueble.Pago;
import com.example.inmueble.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToolsFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ListaPagosAdapter listaPagosAdapter;
    private ArrayList<String> listaInmueble = new ArrayList<>();
    private Map<String,ArrayList<Pago>> mapPago = new HashMap<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        expandableListView = root.findViewById(R.id.expPago);

        cargarDatos();
        listaPagosAdapter = new ListaPagosAdapter(listaInmueble,mapPago,getContext());
        expandableListView.setAdapter(listaPagosAdapter);

        return root;
    }


    private void cargarDatos(){
            listaInmueble.add("San Martin 300");
            listaInmueble.add("Ayacucho 300");
            listaInmueble.add("Lafinur 300");
            listaInmueble.add("España 300");

            ArrayList<Pago> sanMartin = new ArrayList<>();
            ArrayList<Pago> ayacucho = new ArrayList<>();
            ArrayList<Pago> lafinur = new ArrayList<>();
            ArrayList<Pago> espania = new ArrayList<>();

            sanMartin.add(new Pago(1,12,"09-12-2018",123,9));
            sanMartin.add(new Pago(2,13,"15-12-2018",123,8));
            sanMartin.add(new Pago(3,14,"28-12-2018",123,7));


            ayacucho.add(new Pago(4,34,"23-01-2019",1232,6));
            ayacucho.add(new Pago(5,36,"15-02-2019",1235,5));
            ayacucho.add(new Pago( 6,87,"28-03-2019",1236,4));

            lafinur.add(new Pago(7,12,"09-12-2018",123,3));
            lafinur.add(new Pago(8,13,"15-12-2018",123,2));
            lafinur.add(new Pago(9,14,"28-12-2018",123,1));

            espania.add(new Pago(10,12,"09-12-2018",123,11));
            espania.add(new Pago(11,13,"15-12-2018",123,10));

            mapPago.put(listaInmueble.get(0),sanMartin);
            mapPago.put(listaInmueble.get(1),ayacucho);
            mapPago.put(listaInmueble.get(2),lafinur);
            mapPago.put(listaInmueble.get(3),espania);



    }
}