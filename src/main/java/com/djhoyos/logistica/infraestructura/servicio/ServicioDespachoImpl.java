package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaDespacho;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaTipoProducto;
import com.djhoyos.logistica.dominio.modelo.Despacho;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioDespacho;
import com.djhoyos.logistica.infraestructura.entidad.EntidadDespacho;
import com.djhoyos.logistica.infraestructura.entidad.EntidadTipoProducto;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioDespacho;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioDespachoImpl implements IRepositorioDespacho {

    private static final Logger logger = LoggerFactory.getLogger(ServicioDespachoImpl.class);

    private final RepositorioDespacho repo;

    public ServicioDespachoImpl(RepositorioDespacho repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<ComandoDespacho> guardar(Despacho despacho) {
        return new ResponseEntity<>(FabricaDespacho.entidad(repo.save(FabricaDespacho.entidadDespacho(despacho))), null, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ComandoDespacho>> lista() {
        return new ResponseEntity<>(repo.findAll().stream().map(FabricaDespacho::entidad).collect(Collectors.toList()), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> eliminar(Integer id) {
        boolean estado = false;
        try {
            repo.deleteById(id);
            estado = true;
        } catch (Exception e) {
            logger.error("Error al eliminar cliente " + e.getMessage());
        }
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }

    @Override
    public Boolean existe(int id) {
        return repo.existsById(id);
    }

    @Override
    public ResponseEntity<ComandoDespacho> getDespacho(int id) {
        return new ResponseEntity<>(FabricaDespacho.entidad(repo.getById(id)), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ComandoDespacho> actualizar(int id, Despacho despacho) {
        EntidadDespacho entidad = repo.getById(id);
        try {
            return new ResponseEntity<>(FabricaDespacho.entidad(repo.save(FabricaDespacho.actualizar(entidad, despacho))), null, HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, null, HttpStatus.UNPROCESSABLE_ENTITY);

        }

    }
}
