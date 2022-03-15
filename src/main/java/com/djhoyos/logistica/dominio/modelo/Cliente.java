package com.djhoyos.logistica.dominio.modelo;

import com.djhoyos.logistica.dominio.enums.TipoIdentificacion;
import com.djhoyos.logistica.dominio.validacion.ValidadorDominio;

public class Cliente extends ValidadorDominio {

    private int id;
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;

    public Cliente(int id, TipoIdentificacion tipoIdentificacion, String numeroIdentificacion, String nombre, String direccion, String telefono, String celular, String correo) {
        setId(id);
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setCelular(celular);
        setCorreo(correo);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    private void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        validarParametrosObligatorio(tipoIdentificacion, "Tipo de Identificación");
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion) {
        validarParametrosObligatorio(numeroIdentificacion, "Número de Identificación");
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        validarParametrosObligatorio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    private void setDireccion(String direccion) {
        validarParametrosObligatorio(direccion, "Dirección de residencia");
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    private void setCelular(String celular) {
        validarParametrosObligatorio(celular, "Célular");
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    private void setCorreo(String correo) {
        validarParametrosObligatorio(celular, "Correo electrónico");
        this.correo = correo;
    }
}
