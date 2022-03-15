package com.djhoyos.logistica.infraestructura.repositorio;

import com.djhoyos.logistica.dominio.enums.RolNombre;
import com.djhoyos.logistica.infraestructura.entidad.EntidadRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioRol extends JpaRepository<EntidadRol, Integer> {

    Optional<EntidadRol> findByRolNombre(RolNombre rolNombre);
}
