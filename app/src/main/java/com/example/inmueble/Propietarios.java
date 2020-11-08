package com.example.inmueble;

public class Propietarios {

    private int idPropietario;
    private String apellido;
    private String nombre;
    private int dni;
    private int telefono;
    private String email;
    private String clave;

    public Propietarios() {
    }

    public Propietarios(int idPropietario, String apellido, String nombre, int dni, int telefono, String email, String clave) {
        this.idPropietario = idPropietario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;

        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
    }

    public int getIdPropietario() {return idPropietario;}

    public void setIdPropietario(int idPropietario) {this.idPropietario = idPropietario;}

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }



    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Propietarios{" +
                "idPropietario=" + idPropietario +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
