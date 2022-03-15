package com.djhoyos.logistica.aplicacion.manejador;

import com.djhoyos.logistica.aplicacion.comando.ComandoUsuario;
import com.djhoyos.logistica.dominio.servicio.ServicioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorUsuario {

    private ServicioUsuario servicioUsuario;

    public ManejadorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    public ResponseEntity<Boolean> existeNombreUsuario(String nombre) {
        return servicioUsuario.existeNombreUsuario(nombre);
    }

    public ResponseEntity<Boolean> existeCorreo(String correo) {
        return servicioUsuario.existeCorreo(correo);
    }

    public ResponseEntity<ComandoUsuario> registrarUsuario(ComandoUsuario comandoUsuario) {
       return servicioUsuario.registrarUsuario(comandoUsuario);
    }
}
