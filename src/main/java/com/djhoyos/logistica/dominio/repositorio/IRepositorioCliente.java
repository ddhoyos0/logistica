package com.djhoyos.logistica.dominio.repositorio;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.dominio.modelo.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRepositorioCliente {

    ResponseEntity<ComandoCliente> guardar(Cliente cliente);

    ResponseEntity<List<ComandoCliente>> listar();

    ResponseEntity<Boolean> eliminar(Integer id);
}
