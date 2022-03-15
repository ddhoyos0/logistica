package com.djhoyos.logistica.dominio.modelo;

import com.djhoyos.logistica.dominio.validacion.ValidadorDominio;

public class Login extends ValidadorDominio {

    private String nombreUsuario;
    private String password;

    private static final String MENSAJE_ERROR_NOMBRE_USUARIO = "El nombre de usuario es obligatorio";
    private static final String MENSAJE_ERROR_PASSWORD = "El password es obligatorio";


    public Login(String nombreUsuario, String password) {
        setNombreUsuario(nombreUsuario);
        setPassword(password);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    private void setNombreUsuario(String nombreUsuario) {
        validarParametrosObligatorio(nombreUsuario, MENSAJE_ERROR_NOMBRE_USUARIO);
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        validarParametrosObligatorio(nombreUsuario, MENSAJE_ERROR_PASSWORD);
        this.password = password;
    }
}
