package com.djhoyos.logistica.dominio.modelo;

import com.djhoyos.logistica.dominio.enums.TipoEnvio;
import com.djhoyos.logistica.dominio.validacion.ValidadorDominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Despacho extends ValidadorDominio {

    private int id;
    private TipoEnvio tipoEnvio;
    private TipoProducto tipoProducto;
    private int cantidad;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaEntrega;
    private String lugarEntrega;
    private Double precio;
    private String placa;
    private String numeroGuia;
    private Double descuento;
    private Cliente cliente;

    public Despacho(int id, TipoEnvio tipoEnvio, TipoProducto tipoProducto, int cantidad, LocalDateTime fechaRegistro, LocalDate fechaEntrega, String lugarEntrega, Double precio, String placa, String numeroGuia, Double descuento, Cliente cliente) {
        setId(id);
        setTipoEnvio(tipoEnvio);
        setTipoProducto(tipoProducto);
        setCantidad(cantidad);
        setFechaRegistro(fechaRegistro);
        setFechaEntrega(fechaEntrega);
        setLugarEntrega(lugarEntrega);
        setPrecio(precio);
        setPlaca(placa);
        setNumeroGuia(numeroGuia);
        setDescuento(descuento);
        setCliente(cliente);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    private void setTipoEnvio(TipoEnvio tipoEnvio) {
        validarParametrosObligatorio(tipoEnvio, "Tipo de Envío");
        this.tipoEnvio = tipoEnvio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    private void setTipoProducto(TipoProducto tipoProducto) {
        validarParametrosObligatorio(tipoProducto, "Tipo de Producto");
        this.tipoProducto = tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    private void setCantidad(int cantidad) {
        validarParametrosObligatorio(cantidad, "Cantidad");
        validarParametrosNumericos(cantidad, "Cantidad");
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    private void setFechaRegistro(LocalDateTime fechaRegistro) {
        validarParametrosObligatorio(fechaRegistro, "Fecha de Registro");
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    private void setFechaEntrega(LocalDate fechaEntrega) {
        validarParametrosObligatorio(fechaEntrega, "Fecha de Entrega");
        this.fechaEntrega = fechaEntrega;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    private void setLugarEntrega(String lugarEntrega) {
        validarParametrosObligatorio(lugarEntrega, "Lugar de Entrega");
        this.lugarEntrega = lugarEntrega;
    }

    public Double getPrecio() {
        return precio;
    }

    private void setPrecio(Double precio) {
        validarParametrosObligatorio(precio, "Precio");
        validarParametrosDouble(precio, "Precio");
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    private void setPlaca(String placa) {
        validarParametrosObligatorio(placa, "Placa");
        validarPlaca(placa, tipoEnvio);
        this.placa = placa;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    private void setNumeroGuia(String numeroGuia) {
        validarParametrosObligatorio(numeroGuia, "Número de Guía");
        this.numeroGuia = numeroGuia;
    }

    public Double getDescuento() {
        return descuento;
    }

    private void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        validarParametrosObligatorio(cliente, "Cliente");
        this.cliente = cliente;
    }
}
