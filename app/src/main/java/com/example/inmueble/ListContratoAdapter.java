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

public class ListContratoAdapter extends ArrayAdapter<Alquiler> {

    private Context context;
    private List<Alquiler> lista;
    private LayoutInflater li;
    public ListContratoAdapter(@NonNull Context context, int resource, @NonNull List<Alquiler> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView==null){
            itemView = li.inflate(R.layout.itemcontrato, parent, false);
        }
        Alquiler alquiler = lista.get(position);

        TextView precio = itemView.findViewById(R.id.precioCon);
        precio.setText(alquiler.getPrecio() +"");

        TextView fechaInicio = itemView.findViewById(R.id.fechaInicioCon);
        fechaInicio.setText(alquiler.getFechaInicio());

        TextView fechaFinal = itemView.findViewById(R.id.fechaFinalizacionCon);
        fechaFinal.setText(alquiler.getFechaFin() +"");

        return itemView;
    }
}
