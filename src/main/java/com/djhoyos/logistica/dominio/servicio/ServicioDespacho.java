package com.djhoyos.logistica.dominio.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.dominio.modelo.Despacho;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioDespacho;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ServicioDespacho {

    public final IRepositorioDespacho repo;

    public ServicioDespacho(IRepositorioDespacho repo) {
        this.repo = repo;
    }

    public ResponseEntity<ComandoDespacho> guardar(Despacho despacho) {
        return repo.guardar(despacho);
    }

    public ResponseEntity<List<ComandoDespacho>> listar() {
        return repo.lista();
    }

    public ResponseEntity<Boolean> eliminar(Integer id) {
        return repo.eliminar(id);
    }

    public Boolean existe(int id) {
        return repo.existe(id);
    }

    public ResponseEntity<ComandoDespacho> getDespacho(int id) {
        return repo.getDespacho(id);
    }

    public ResponseEntity<ComandoDespacho> actualizar(int id, Despacho modelo) {
        return repo.actualizar(id, modelo);
    }
}
