package com.djhoyos.logistica.dominio.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.dominio.modelo.Cliente;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioCliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ServicioCliente {

    private final IRepositorioCliente repo;

    public ServicioCliente(IRepositorioCliente repo) {
        this.repo = repo;
    }

    public ResponseEntity<ComandoCliente> guardar(Cliente cliente) {
        return repo.guardar(cliente);
    }

    public ResponseEntity<List<ComandoCliente>> listar() {
        return repo.listar();
    }

    public ResponseEntity<Boolean> eliminar(Integer id) {
        return repo.eliminar(id);
    }

    public Boolean existeCliente(int id) {
        return repo.existeCliente(id);
    }

    public ResponseEntity<ComandoCliente> getCliente(int id) {
        return repo.getCliente(id);
    }

    public ResponseEntity<ComandoCliente> actualizar(int id, Cliente cliente) {
        return repo.actualizar(id, cliente);
    }
}
