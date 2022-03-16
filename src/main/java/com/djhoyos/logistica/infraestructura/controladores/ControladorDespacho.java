package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.aplicacion.comando.ComandoMensaje;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorDespacho;
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
@RequestMapping("despacho")
@CrossOrigin
public class ControladorDespacho {

    private final ManejadorDespacho manejador;

    public ControladorDespacho(ManejadorDespacho manejador) {
        this.manejador = manejador;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ComandoDespacho> registrar(@RequestBody ComandoDespacho comando) {
        return manejador.guardar(comando);
    }

    @GetMapping("/listado")
    public ResponseEntity<List<ComandoDespacho>> listar() {
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
        if (!manejador.existe(id)) {
            return new ResponseEntity<>(new ComandoMensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        return manejador.getDespacho(id);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") int id, @RequestBody ComandoDespacho comando) {
        if (!manejador.existe(id))
            return new ResponseEntity<>(new ComandoMensaje("no existe"), HttpStatus.NOT_FOUND);
        return manejador.actualizar(id, comando);
    }
}
