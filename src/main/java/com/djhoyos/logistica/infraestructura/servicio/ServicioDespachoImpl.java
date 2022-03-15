package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaDespacho;
import com.djhoyos.logistica.dominio.modelo.Despacho;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioDespacho;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioDespacho;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioDespachoImpl implements IRepositorioDespacho {

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
}
