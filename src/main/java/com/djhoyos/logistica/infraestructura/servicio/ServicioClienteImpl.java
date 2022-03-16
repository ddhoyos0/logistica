package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaCliente;
import com.djhoyos.logistica.dominio.modelo.Cliente;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioCliente;
import com.djhoyos.logistica.infraestructura.entidad.EntidadCliente;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioClienteImpl implements IRepositorioCliente {

    private static final Logger logger = LoggerFactory.getLogger(ServicioClienteImpl.class);

    private RepositorioCliente repo;

    @Autowired
    public ServicioClienteImpl(RepositorioCliente repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<ComandoCliente> guardar(Cliente cliente) {
        EntidadCliente entidad = repo.save(FabricaCliente.entidad(cliente));
        return new ResponseEntity<>(FabricaCliente.comando(entidad), null, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ComandoCliente>> listar() {
        return new ResponseEntity<>(repo.findAll().stream().map(FabricaCliente::comando).collect(Collectors.toList()), HttpStatus.OK);
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
    public Boolean existeCliente(int id) {
        return repo.existsById(id);
    }

    @Override
    public ResponseEntity<ComandoCliente> getCliente(int id) {
        return new ResponseEntity<>(FabricaCliente.comando(repo.getById(id)), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ComandoCliente> actualizar(int id, Cliente cliente) {
        EntidadCliente entidad = repo.getById(id);
        return new ResponseEntity<>(FabricaCliente.comando(repo.save(FabricaCliente.actualizar(entidad, cliente))), null, HttpStatus.OK);
    }
}
