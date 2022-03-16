package com.djhoyos.logistica.dominio.repositorio;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.dominio.modelo.Despacho;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRepositorioDespacho {

    ResponseEntity<ComandoDespacho> guardar(Despacho despacho);

    ResponseEntity<List<ComandoDespacho>>lista();
}
