package com.example.inmueble.ui.gallery;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.inmueble.Inmueble;
import com.example.inmueble.Propietarios;
import com.example.inmueble.R;


public class ClienteFragment extends Fragment {

    private EditText etDomicilio,etAmbientes,etPrecio,etTipo,etUso;

    private CheckBox cbDiponible;
    private Button btnEditar;
    private Inmueble inmueble;
    private Inmueble inmu2 = new Inmueble();
    private ClienteViewModel viewModel;

    public ClienteFragment(Inmueble inmueble1){
        this.inmueble = inmueble1;
    }

    private OnFragmentInteractionListener mListener;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_cliente, container, false);
        inicializar(root);
        return root;

    }

    private void inicializar(View v){
        etDomicilio = v.findViewById(R.id.etDomicilioInmueble);
        etAmbientes = v.findViewById(R.id.etAmbientesInmu);
        etPrecio = v.findViewById(R.id.etPrecioInmu);
        etTipo = v.findViewById(R.id.etTipoInmueble);
        etUso = v.findViewById(R.id.etUsoInmueble);
        cbDiponible = v.findViewById(R.id.cbDiponibleInmu);
        btnEditar = v.findViewById(R.id.btnEditarInmu);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ClienteViewModel.class);

        viewModel.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                etDomicilio.setText(inmueble.getDireccion());
                etDomicilio.setEnabled(false);
                etAmbientes.setText(inmueble.getAmbientes()+"");
                etAmbientes.setEnabled(false);
                etPrecio.setText(inmueble.getPrecio()+"");
                etPrecio.setEnabled(false);
                etTipo.setText(inmueble.getTipo());
                etTipo.setEnabled(false);
                etUso.setText(inmueble.getUso());
                etUso.setEnabled(false);
                cbDiponible.setChecked(inmueble.isDisponible());



            }
        });

        viewModel.getEstado().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                cbDiponible.setEnabled(aBoolean);

            }
        });
        viewModel.getTextoBoton().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btnEditar.setText(s);
            }
        });



        viewModel.rellenar(inmueble);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inmu2.setIdInmueble(inmueble.getIdInmueble());
                inmu2.setDireccion(etDomicilio.getText().toString());
                inmu2.setAmbientes(Integer.parseInt(etAmbientes.getText().toString()));
                inmu2.setPrecio(Double.valueOf(etPrecio.getText().toString()));
                inmu2.setTipo(etTipo.getText().toString());
                inmu2.setUso(etUso.getText().toString());
                inmu2.setDisponible(cbDiponible.isChecked());
                viewModel.guardar(inmu2);
                viewModel.editar();

            }
        });






    }








    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
