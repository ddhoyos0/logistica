package com.djhoyos.logistica.dominio.modelo;

import com.djhoyos.logistica.dominio.validacion.ValidadorDominio;

public class TipoProducto extends ValidadorDominio {

    private int id;
    private String codigo;
    private String nombre;
    private Double precio;

    public TipoProducto(int id, String codigo, String nombre, Double precio) {
        setId(id);
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(String codigo) {
        validarParametrosObligatorio(codigo, "Código");
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        validarParametrosObligatorio(nombre, "Nombre");
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    private void setPrecio(Double precio) {
        validarParametrosObligatorio(precio, "Precio");
        validarParametrosDouble(precio, "Precio");
        this.precio = precio;
    }
}
