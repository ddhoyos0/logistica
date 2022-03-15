package com.djhoyos.logistica.dominio.repositorio;

import com.djhoyos.logistica.aplicacion.comando.ComandoUsuario;
import com.djhoyos.logistica.dominio.modelo.Usuario;
import org.springframework.http.ResponseEntity;

public interface IRepositorioUsuario {

    ResponseEntity<ComandoUsuario> getNombreUsuario(String nombreUsuario);

    ResponseEntity<Boolean> existeNombreUsuario(String nombreUsuario);

    ResponseEntity<Boolean> existeCorreo(String correo);

    ResponseEntity<ComandoUsuario> guardar(Usuario usuario);
}
