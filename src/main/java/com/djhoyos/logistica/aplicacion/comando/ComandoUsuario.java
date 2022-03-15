package com.djhoyos.logistica.aplicacion.comando;

import java.util.HashSet;
import java.util.Set;

public class ComandoUsuario {

    private String nombre;
    private String nombreUsuario;
    private String correo;
    private String password;
    private Set<String> roles = new HashSet<>();

    public ComandoUsuario(String nombre, String nombreUsuario, String correo, String password, Set<String> roles) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
