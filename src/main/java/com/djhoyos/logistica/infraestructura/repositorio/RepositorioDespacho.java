package com.djhoyos.logistica.infraestructura.repositorio;

import com.djhoyos.logistica.infraestructura.entidad.EntidadDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDespacho extends JpaRepository<EntidadDespacho, Long> {
}
