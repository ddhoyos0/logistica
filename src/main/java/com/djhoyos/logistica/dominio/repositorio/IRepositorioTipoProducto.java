package com.djhoyos.logistica.dominio.repositorio;

import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.dominio.modelo.TipoProducto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRepositorioTipoProducto {

    ResponseEntity<ComandoTipoProducto> guardar(TipoProducto tipoProducto);

    ResponseEntity<List<ComandoTipoProducto>> listar();

    ResponseEntity<Boolean> eliminar(Integer id);

    Boolean existe(int id);

    ResponseEntity<ComandoTipoProducto> getTipoProducto(int id);

    ResponseEntity<ComandoTipoProducto> actualizar(int id, TipoProducto tipoProducto);
}
