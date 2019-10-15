package com.example.inmueble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ListaContratosAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> listaInmueble;
    private Map<String,ArrayList<Alquiler>> mapChild;
    private Context context;

    public ListaContratosAdapter(ArrayList<String> listaInmueble, Map<String, ArrayList<Alquiler>> mapChild, Context context) {
        this.listaInmueble = listaInmueble;
        this.mapChild = mapChild;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listaInmueble.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mapChild.get(listaInmueble.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listaInmueble.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mapChild.get(listaInmueble.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String nombreInmueble =  (String) getGroup(i);

        view = LayoutInflater.from(context).inflate(R.layout.iteminmueble,null);
        TextView tvGrup = view.findViewById(R.id.tvInmueble);
        tvGrup.setText(nombreInmueble);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Alquiler alquiler = (Alquiler) getChild(i,i1);
        view = LayoutInflater.from(context).inflate(R.layout.itemcontrato,null);

        TextView tvFechaInicio = view.findViewById(R.id.fechaInicio);
        tvFechaInicio.setText(alquiler.getFechaInicio());

        TextView tvFechaFin = view.findViewById(R.id.fechaFinalizacion);
        tvFechaFin.setText(alquiler.getFechaFin());

        TextView tvPrecio = view.findViewById(R.id.precio);
        tvPrecio.setText(alquiler.getPrecio()+"");

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
