package com.djhoyos.logistica.aplicacion.comando;

public class ComandoTipoProducto {

    private int id;
    private String codigo;
    private String nombre;
    private Double precio;

    public ComandoTipoProducto(int id, String codigo, String nombre, Double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
}
