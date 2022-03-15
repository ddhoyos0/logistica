package com.djhoyos.logistica.aplicacion.comando;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoDespacho {

    private int id;
    private String tipoEnvio;
    private ComandoTipoProducto tipoProducto;
    private int cantidad;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaEntrega;
    private String lugarEntrega;
    private Double precio;
    private String placa;
    private String numeroGuia;
    private Double descuento;
    private ComandoCliente cliente;

    public ComandoDespacho(int id, String tipoEnvio, ComandoTipoProducto tipoProducto, int cantidad, LocalDateTime fechaRegistro, LocalDate fechaEntrega, String lugarEntrega, Double precio, String placa, String numeroGuia, Double descuento, ComandoCliente cliente) {
        this.id = id;
        this.tipoEnvio = tipoEnvio;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.lugarEntrega = lugarEntrega;
        this.precio = precio;
        this.placa = placa;
        this.numeroGuia = numeroGuia;
        this.descuento = descuento;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public ComandoTipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public Double getDescuento() {
        return descuento;
    }

    public ComandoCliente getCliente() {
        return cliente;
    }
}
