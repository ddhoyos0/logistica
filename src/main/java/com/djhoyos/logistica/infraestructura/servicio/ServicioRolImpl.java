package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoRol;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaRol;
import com.djhoyos.logistica.dominio.enums.RolNombre;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioRol;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioRolImpl implements IRepositorioRol {

    private final RepositorioRol repo;

    @Autowired
    public ServicioRolImpl(RepositorioRol repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<ComandoRol> getRolNombre(RolNombre rolNombre) {
        return new ResponseEntity<ComandoRol>(repo.findByRolNombre(rolNombre).map(FabricaRol::comando).orElse(new ComandoRol()), null, HttpStatus.NOT_FOUND);
    }
}
