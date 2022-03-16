package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorDespacho;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
