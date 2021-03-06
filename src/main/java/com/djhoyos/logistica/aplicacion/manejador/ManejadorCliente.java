package com.djhoyos.logistica.aplicacion.manejador;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaCliente;
import com.djhoyos.logistica.dominio.servicio.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorCliente {

    private ServicioCliente servicio;

    @Autowired
    public ManejadorCliente(ServicioCliente servicio) {
        this.servicio = servicio;
    }

    public ResponseEntity<ComandoCliente> guardar(ComandoCliente comando) {
        return servicio.guardar(FabricaCliente.modelo(comando));
    }

    public ResponseEntity<List<ComandoCliente>> listar() {
        return servicio.listar();
    }

    public ResponseEntity<Boolean> eliminar(Integer id) {
        return servicio.eliminar(id);
    }

    public Boolean existeCliente(int id) {
        return servicio.existeCliente(id);
    }

    public ResponseEntity<ComandoCliente> getCliente(int id) {
        return servicio.getCliente(id);
    }

    public ResponseEntity<ComandoCliente> actualizar(int id, ComandoCliente comando) {
        return servicio.actualizar(id, FabricaCliente.modelo(comando));
    }
}
