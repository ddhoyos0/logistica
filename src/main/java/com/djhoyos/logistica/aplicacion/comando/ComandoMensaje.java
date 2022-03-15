package com.djhoyos.logistica.aplicacion.comando;

public class ComandoMensaje {
    private String mensaje;

    public ComandoMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
