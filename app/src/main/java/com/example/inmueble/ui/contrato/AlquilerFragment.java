package com.example.inmueble.ui.contrato;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmueble.Alquiler;
import com.example.inmueble.R;

import java.util.ArrayList;

public class AlquilerFragment extends Fragment {


    private ArrayList<Alquiler> list = new ArrayList<>();
    private AlquilerViewModel mViewModel;
    private TextView tvTitulo;
    private ListView lv;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.alquiler_fragment, container, false);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(AlquilerViewModel.class);

        mViewModel.getAdapter().observe(getViewLifecycleOwner(), new Observer<ArrayAdapter<Alquiler>>() {
            @Override
            public void onChanged(ArrayAdapter<Alquiler> alquilerArrayAdapter) {
                lv.setAdapter(alquilerArrayAdapter);
            }
        });

        inicializar(root);

        return root;
    }

    public void inicializar(View view){

        tvTitulo = view.findViewById(R.id.tvTituloContratoContainer);
        String x = getArguments().getString("direccion");
        tvTitulo.setText(x);
        tvTitulo.setBackgroundColor(Color.parseColor("#212121"));


        mViewModel.cargarDatos(getLayoutInflater());
        lv = view.findViewById(R.id.listaContratos);


    }



}