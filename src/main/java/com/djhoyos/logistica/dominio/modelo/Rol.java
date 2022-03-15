package com.djhoyos.logistica.dominio.modelo;

public class Rol {

    private String nombreRol;

    public Rol(String nombreRol) {
        setNombreRol(nombreRol);
    }

    public String getNombreRol() {
        return nombreRol;
    }

    private void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
