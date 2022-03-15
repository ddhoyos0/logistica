package com.djhoyos.logistica.aplicacion.comando;

public class ComandoCliente {

    private int id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;

    public ComandoCliente(int id, String tipoIdentificacion, String numeroIdentificacion, String nombre, String direccion, String telefono, String celular, String correo) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }
}
