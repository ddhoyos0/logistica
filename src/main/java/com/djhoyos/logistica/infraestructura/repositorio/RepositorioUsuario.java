package com.djhoyos.logistica.infraestructura.repositorio;

import com.djhoyos.logistica.infraestructura.entidad.EntidadUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends CrudRepository<EntidadUsuario, Integer> {

    Optional<EntidadUsuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);

    boolean existsByCorreo(String correo);
}
