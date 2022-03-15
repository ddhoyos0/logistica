package com.djhoyos.logistica.infraestructura.excepciones;

import java.time.LocalDateTime;

public class ApiError {

    private LocalDateTime fecha;
    private String mensaje;
    private String descripcion;

    public ApiError(LocalDateTime fecha, String mensaje, String descripcion) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
