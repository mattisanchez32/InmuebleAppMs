package com.example.inmueble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ListaPagosAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> listaInmuble;
    private Map<String, ArrayList<Pago>> mapChild;
    private Context context;

    public ListaPagosAdapter(ArrayList<String> listaInmuble, Map<String, ArrayList<Pago>> mapChild, Context context) {
        this.listaInmuble = listaInmuble;
        this.mapChild = mapChild;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listaInmuble.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mapChild.get(listaInmuble.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listaInmuble.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mapChild.get(listaInmuble.get(i)).get(i1);
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
        Pago pago = (Pago) getChild(i,i1);

        view = LayoutInflater.from(context).inflate(R.layout.itempago,null);

        TextView tvpago = view.findViewById(R.id.nroPago);
        tvpago.setText(pago.getNroPago()+"");

        TextView tvfecha = view.findViewById(R.id.fecha);
        tvfecha.setText(pago.getFecha());

        TextView tvimporte = view.findViewById(R.id.importe);
        tvimporte.setText(pago.getImporte()+"");



        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
