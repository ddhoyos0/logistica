/*
package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.dominio.enums.RolNombre;
import com.djhoyos.logistica.infraestructura.entidad.EntidadRol;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioRol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearRolImpl implements CommandLineRunner {

    private RepositorioRol repo;

    public ServicioCrearRolImpl(RepositorioRol repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        EntidadRol rolAdmin = new EntidadRol(RolNombre.ROLE_ADMINITRADOR);
        EntidadRol rolUser = new EntidadRol(RolNombre.ROLE_USUARIO);
        repo.save(rolAdmin);
        repo.save(rolUser);

    }
}
*/
