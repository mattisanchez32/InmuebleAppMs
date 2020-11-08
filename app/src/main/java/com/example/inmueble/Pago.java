package com.example.inmueble;

public class Pago {

    private int idPago;
    private int nroPago;
    private String fecha;
    private double importe;
    private int idAquiler;

    public Pago(int idPago, int nroPago, String fecha, double importe, int idAquiler) {
        this.idPago = idPago;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.idAquiler = idAquiler;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdAquiler() {
        return idAquiler;
    }

    public void setIdAquiler(int idAquiler) {
        this.idAquiler = idAquiler;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
