package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.aplicacion.comando.ComandoUsuario;
import com.djhoyos.logistica.aplicacion.fabrica.FabricaUsuario;
import com.djhoyos.logistica.dominio.enums.RolNombre;
import com.djhoyos.logistica.dominio.modelo.Usuario;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioUsuario;
import com.djhoyos.logistica.infraestructura.entidad.EntidadRol;
import com.djhoyos.logistica.infraestructura.entidad.EntidadUsuario;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioRol;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServicioUsuarioImpl implements IRepositorioUsuario {

    private final RepositorioUsuario repo;
    private final RepositorioRol repoRol;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repo,  RepositorioRol repoRol) {
        this.repo = repo;
        this.repoRol = repoRol;
    }

    @Override
    public ResponseEntity<ComandoUsuario> getNombreUsuario(String nombreUsuario) {
        return new ResponseEntity<>(repo.findByNombreUsuario(nombreUsuario).map(FabricaUsuario::comando).orElse(null), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> existeNombreUsuario(String nombreUsuario) {
        return new ResponseEntity<>(repo.existsByNombreUsuario(nombreUsuario), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> existeCorreo(String correo) {
        return new ResponseEntity<>(repo.existsByCorreo(correo), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ComandoUsuario> guardar(Usuario usuario) {
        Set<EntidadRol> roles = usuario.getRoles().stream().map(r-> repoRol.findByRolNombre(RolNombre.valueOf(r)).get()).collect(Collectors.toSet());
        EntidadUsuario entidad = repo.save(FabricaUsuario.modelo(usuario, roles));
        return new ResponseEntity<>(FabricaUsuario.comando(entidad), null, HttpStatus.CREATED);
    }
}
