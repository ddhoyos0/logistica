package com.djhoyos.logistica.dominio.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.dominio.modelo.TipoProducto;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioTipoProducto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ServicioTipoProducto {

    private IRepositorioTipoProducto repo;

    public ServicioTipoProducto(IRepositorioTipoProducto repo) {
        this.repo = repo;
    }

    public ResponseEntity<ComandoTipoProducto> guardar(TipoProducto tipoProducto) {
        return repo.guardar(tipoProducto);
    }

    public ResponseEntity<List<ComandoTipoProducto>> listar() {
        return repo.listar();
    }

    public ResponseEntity<Boolean> eliminar(Integer id) {
        return repo.eliminar(id);
    }

    public Boolean existe(int id) {
        return repo.existe(id);
    }

    public ResponseEntity<ComandoTipoProducto> getTipoProducto(int id) {
        return repo.getTipoProducto(id);
    }

    public ResponseEntity<ComandoTipoProducto> actualizar(int id, TipoProducto tipoProducto) {
        return repo.actualizar(id, tipoProducto);
    }
}
