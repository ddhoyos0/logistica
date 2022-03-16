package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaTipoProducto;
import com.djhoyos.logistica.dominio.modelo.TipoProducto;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioTipoProducto;
import com.djhoyos.logistica.infraestructura.entidad.EntidadTipoProducto;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioTipoProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioTipoProductoImpl implements IRepositorioTipoProducto {

    private static final Logger logger = LoggerFactory.getLogger(ServicioTipoProductoImpl.class);

    private RepositorioTipoProducto repo;

    @Autowired
    public ServicioTipoProductoImpl(RepositorioTipoProducto repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<ComandoTipoProducto> guardar(TipoProducto tipoProducto) {
        EntidadTipoProducto entidad = repo.save(FabricaTipoProducto.entidadTipoProducto(tipoProducto));
        return new ResponseEntity<>(FabricaTipoProducto.entidad(entidad), null, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ComandoTipoProducto>> listar() {
        return new ResponseEntity<>(repo.findAll().stream().map(FabricaTipoProducto::entidad).collect(Collectors.toList()), HttpStatus.OK);
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
    public ResponseEntity<ComandoTipoProducto> getTipoProducto(int id) {
        return new ResponseEntity<>(FabricaTipoProducto.entidad(repo.getById(id)), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ComandoTipoProducto> actualizar(int id, TipoProducto tipoProducto) {
        EntidadTipoProducto entidad = repo.getById(id);
        return new ResponseEntity<>(FabricaTipoProducto.entidad(repo.save(FabricaTipoProducto.actualizar(entidad, tipoProducto))), null, HttpStatus.OK);
    }
}
