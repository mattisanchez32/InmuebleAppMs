package com.example.inmueble.ui.contrato;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmueble.Alquiler;
import com.example.inmueble.Inmueble;
import com.example.inmueble.ListaContratosAdapter;
import com.example.inmueble.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContratoFragment extends Fragment {




    private ListView listView;
    ArrayList<Inmueble> listaInmueble = new ArrayList<>();
    private ContratoViewModel viewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contrato, container, false);




        inicializar(root);

        return root;

    }

    public void inicializar(View view){
        listView = view.findViewById(R.id.listaPropiedadesContratos);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);

        viewModel.getListaDirecciones().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, strings);
                listView.setAdapter(adapter);
            }
        });


        viewModel.cargarDatos();


        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)view;
                Bundle bundle = new Bundle();
                bundle.putString("direccion", tv.getText().toString());
                Navigation.findNavController(view).navigate(R.id.nav_alquiler, bundle);
            }
        });
    }

    /*private void cargarDatos(){
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

    }*/








}
