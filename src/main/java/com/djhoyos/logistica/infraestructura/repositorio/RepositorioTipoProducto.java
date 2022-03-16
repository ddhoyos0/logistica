package com.djhoyos.logistica.infraestructura.repositorio;

import com.djhoyos.logistica.infraestructura.entidad.EntidadTipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoProducto extends JpaRepository<EntidadTipoProducto, Integer> {
}
