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
}
