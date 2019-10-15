package com.example.inmueble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListaInquilinosAdapter extends ArrayAdapter<Inquilino> {

    private Context context;
    private List<Inquilino> lista;
    private LayoutInflater li;

    public ListaInquilinosAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context=context;
        this.lista=objects;
        this.li=li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView=convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.iteminquilino,parent,false);
        }
        Inquilino inquilino = lista.get(position);

        TextView dni = itemView.findViewById(R.id.dni);
        dni.setText(inquilino.getDni()+"");

        TextView apellido = itemView.findViewById(R.id.apellido);
        apellido.setText(inquilino.getApellido());

        TextView nombre = itemView.findViewById(R.id.nombre);
        nombre.setText(inquilino.getNombre());

        TextView direccion = itemView.findViewById(R.id.direccion);
        direccion.setText(inquilino.getDireccion());

        TextView telefono = itemView.findViewById(R.id.telefono);
        telefono.setText(inquilino.getTelefono()+"");

        return itemView;

    }
}
