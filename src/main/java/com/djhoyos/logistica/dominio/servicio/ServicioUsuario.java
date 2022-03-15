package com.djhoyos.logistica.dominio.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoUsuario;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaUsuario;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioRol;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioUsuario;
import org.springframework.http.ResponseEntity;

public class ServicioUsuario {

    private IRepositorioUsuario repositorioUsuario;
    private IRepositorioRol repositorioRol;

    public ServicioUsuario(IRepositorioUsuario repositorioUsuario, IRepositorioRol repositorioRol) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioRol = repositorioRol;
    }

    public ResponseEntity<Boolean> existeNombreUsuario(String nombre) {
        return repositorioUsuario.existeNombreUsuario(nombre);
    }
    public ResponseEntity<Boolean> existeCorreo(String correo) {
        return repositorioUsuario.existeCorreo(correo);
    }

    public ResponseEntity<ComandoUsuario> registrarUsuario(ComandoUsuario comandoUsuario) {
      return repositorioUsuario.guardar(FabricaUsuario.modeloUsuario(comandoUsuario));
    }
}
