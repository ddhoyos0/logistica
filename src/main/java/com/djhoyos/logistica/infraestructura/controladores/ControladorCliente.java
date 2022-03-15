package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
@CrossOrigin
public class ControladorCliente {

    private final ManejadorCliente manejador;

    @Autowired
    public ControladorCliente(ManejadorCliente manejador) {
        this.manejador = manejador;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ComandoCliente> registrar(@RequestBody ComandoCliente comando) {
        return manejador.guardar(comando);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ComandoCliente>> listar() {
        return manejador.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return manejador.eliminar(id);
    }
}
