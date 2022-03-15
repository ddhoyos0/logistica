package com.djhoyos.logistica.dominio.repositorio;

import com.djhoyos.logistica.aplicacion.comando.ComandoRol;
import com.djhoyos.logistica.dominio.enums.RolNombre;
import org.springframework.http.ResponseEntity;

public interface IRepositorioRol {

    ResponseEntity<ComandoRol> getRolNombre(RolNombre rolNombre);
}
