package com.djhoyos.logistica.aplicacion.manejador;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaDespacho;
import com.djhoyos.logistica.dominio.servicio.ServicioDespacho;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorDespacho {

    private final ServicioDespacho servicio;

    public ManejadorDespacho(ServicioDespacho servicio) {
        this.servicio = servicio;
    }

    public ResponseEntity<ComandoDespacho> guardar(ComandoDespacho despacho) {
        return servicio.guardar(FabricaDespacho.modelo(despacho));
    }

    public ResponseEntity<List<ComandoDespacho>> listar() {
        return servicio.listar();
    }
}
