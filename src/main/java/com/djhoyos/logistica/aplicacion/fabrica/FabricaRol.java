package com.djhoyos.logistica.aplicacion.fabrica;

import com.djhoyos.logistica.aplicacion.comando.ComandoRol;
import com.djhoyos.logistica.dominio.modelo.Rol;
import com.djhoyos.logistica.infraestructura.entidad.EntidadRol;
import org.springframework.stereotype.Component;

@Component
public final class FabricaRol {

    public FabricaRol() {
    }

    public static ComandoRol comando(EntidadRol rol) {
        return new ComandoRol(rol.getRolNombre().name());
    }

    public static Rol modelo(ComandoRol comando) {
        return new Rol(comando.getNombreRol());
    }
}
