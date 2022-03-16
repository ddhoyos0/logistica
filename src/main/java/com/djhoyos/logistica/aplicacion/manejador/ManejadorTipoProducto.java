package com.djhoyos.logistica.aplicacion.manejador;

import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaTipoProducto;
import com.djhoyos.logistica.dominio.servicio.ServicioTipoProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorTipoProducto {

    private ServicioTipoProducto servicio;

    public ManejadorTipoProducto(ServicioTipoProducto servicio) {
        this.servicio = servicio;
    }

    public ResponseEntity<ComandoTipoProducto> guardar(ComandoTipoProducto comando) {
        return servicio.guardar(FabricaTipoProducto.modelo(comando));
    }

    public ResponseEntity<List<ComandoTipoProducto>> listar() {
        return servicio.listar();
    }

    public ResponseEntity<Boolean> eliminar(Integer id) {
        return servicio.eliminar(id);
    }

    public Boolean existe(int id) {
        return servicio.existe(id);
    }

    public ResponseEntity<ComandoTipoProducto> getTipoProducto(int id) {
        return servicio.getTipoProducto(id);
    }

    public ResponseEntity<ComandoTipoProducto> actualizar(int id, ComandoTipoProducto comando) {
        return servicio.actualizar(id, FabricaTipoProducto.modelo(comando));
    }
}
