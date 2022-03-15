package com.djhoyos.logistica.infraestructura.entidad;

import com.djhoyos.logistica.dominio.enums.TipoEnvio;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "despachos")
public class EntidadDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipo_producto_id", referencedColumnName = "id", nullable = false)
    private EntidadTipoProducto tipoProducto;

    @NotNull
    private int cantidad;

    @Column(name = "fecha_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    @Column(name = "lugar_entrega", nullable = false)
    private String lugarEntrega;

    @NotNull
    private Double precio;

    @NotNull
    private String placa;

    @Column(name = "numero_guia", nullable = false)
    private String numeroGuia;

    private Double descuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id", nullable=false)
    private EntidadCliente cliente;

    public EntidadDespacho(int id, TipoEnvio tipoEnvio, EntidadTipoProducto tipoProducto, int cantidad, LocalDateTime fechaRegistro, LocalDate fechaEntrega, String lugarEntrega, Double precio, String placa, String numeroGuia, Double descuento, EntidadCliente cliente) {
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

    public EntidadDespacho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public EntidadTipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(EntidadTipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public EntidadCliente getCliente() {
        return cliente;
    }

    public void setCliente(EntidadCliente cliente) {
        this.cliente = cliente;
    }
}
