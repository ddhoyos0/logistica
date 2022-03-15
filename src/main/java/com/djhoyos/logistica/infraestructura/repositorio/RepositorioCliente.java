package com.djhoyos.logistica.infraestructura.repositorio;

import com.djhoyos.logistica.infraestructura.entidad.EntidadCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<EntidadCliente, Integer> {
}
