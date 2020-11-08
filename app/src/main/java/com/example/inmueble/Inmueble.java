package com.example.inmueble;

public class Inmueble {

    private int idInmueble;
    private String direccion;
    private String tipo;
    private int ambientes;
    private String uso;
    private double precio;
    private boolean disponibilidad;
    private int idPropietario;
    private double latitud;
    private double longitud;
    private int superficie;

    public Inmueble(int idInmueble, String direccion, String tipo, int ambientes, String uso, double precio, boolean disponible, int idPropietario, double latitud, double longitud, int superficie) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.uso = uso;
        this.precio = precio;
        this.disponibilidad = disponible;
        this.idPropietario = idPropietario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.superficie = superficie;
    }

    public Inmueble() {
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponible(boolean disponible) {
        this.disponibilidad = disponible;
    }
}
