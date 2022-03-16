package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.aplicacion.comando.ComandoMensaje;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
@CrossOrigin(origins = "*")
public class ControladorCliente {

    private final ManejadorCliente manejador;

    @Autowired
    public ControladorCliente(ManejadorCliente manejador) {
        this.manejador = manejador;
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/registrar")
    public ResponseEntity<ComandoCliente> registrar(@RequestBody ComandoCliente comando) {
        return manejador.guardar(comando);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/listar")
    public ResponseEntity<List<ComandoCliente>> listar() {
        return manejador.listar();
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return manejador.eliminar(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("get/{id}")
    public ResponseEntity<?> getCliente(@PathVariable("id") int id) {
        if (!manejador.existeCliente(id)) {
            return new ResponseEntity<>(new ComandoMensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        return manejador.getCliente(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") int id, @RequestBody ComandoCliente comando) {
        if (!manejador.existeCliente(id))
            return new ResponseEntity<>(new ComandoMensaje("no existe"), HttpStatus.NOT_FOUND);
        return manejador.actualizar(id, comando);
    }
}
