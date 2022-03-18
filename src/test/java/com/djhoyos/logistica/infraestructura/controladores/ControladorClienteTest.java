package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class ControladorClienteTest {

    @InjectMocks
    private ControladorCliente controlador;

    @Mock
    private ManejadorCliente manejador;

    @Test
    public void testListadoCliente() throws Exception {
        List<ComandoCliente> list = new ArrayList<>();
        list.add(comando());
        Mockito.when(manejador.listar()).thenReturn(new ResponseEntity<>(list, null, HttpStatus.OK));
        ResponseEntity<List<ComandoCliente>> response = controlador.listar();
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(comando().getCelular(), response.getBody().get(0).getCelular());
    }

    @Test
    public void testGetCliente() {
        Mockito.when(manejador.getCliente(1)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.OK));
        Mockito.when(manejador.existeCliente(1)).thenReturn(true);
        ResponseEntity<?> response = controlador.getCliente(1);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void testEliminarCliente() {
        Mockito.when(manejador.eliminar(1)).thenReturn(new ResponseEntity<>(true, null, HttpStatus.OK));
        ResponseEntity<Boolean> response = controlador.eliminar(1);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(response.getBody());
    }

    @Test
    public void testRegistrarCliente() {
        ComandoCliente comando = comando();
        Mockito.when(manejador.guardar(comando)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.CREATED));
        ResponseEntity<ComandoCliente> response = controlador.registrar(comando);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.CREATED));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(comando.getCelular(), response.getBody().getCelular());

    }

    @Test
    public void testActualizarCliente() {
        ComandoCliente comando = comando();
        Mockito.when(manejador.actualizar(1, comando)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.CREATED));
        Mockito.when(manejador.existeCliente(1)).thenReturn(true);
        ResponseEntity<?> response = controlador.actualizar(1, comando);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.CREATED));
        Assertions.assertNotNull(response.getBody());
    }

    private ComandoCliente comando() {
        return new ComandoCliente(1, "CC", "106675421", "Jorge", "Calle 64 58-32", "777777", "3126548978", "jorge@gmail.com");
    }
}