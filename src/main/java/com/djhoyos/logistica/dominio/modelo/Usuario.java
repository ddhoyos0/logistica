package com.djhoyos.logistica.dominio.modelo;

import com.djhoyos.logistica.dominio.validacion.ValidadorDominio;

import java.util.HashSet;
import java.util.Set;

public class Usuario extends ValidadorDominio {

    private String nombre;
    private String nombreUsuario;
    private String correo;
    private String password;
    private Set<String> roles = new HashSet<>();

    public Usuario(String nombre, String nombreUsuario, String correo, String password, Set<String> roles) {
        setNombre(nombre);
        setNombreUsuario(nombreUsuario);
        setCorreo(correo);
        setPassword(password);
        setRoles(roles);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        validarParametrosObligatorio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    private void setNombreUsuario(String nombreUsuario) {
        validarParametrosObligatorio(nombreUsuario, "Nombre de Usuario");
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    private void setCorreo(String correo) {
        validarParametrosObligatorio(correo, "Correo");
        validarParametroTipoEmail(correo);
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        validarParametrosObligatorio(password, "Password");
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    private void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
