package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorTipoProducto;
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
class ControladorTipoProductoTest {

    @InjectMocks
    private ControladorTipoProducto controlador;

    @Mock
    private ManejadorTipoProducto manejador;

    @Test
    public void testListadoTipoProducto() throws Exception {
        List<ComandoTipoProducto> list = new ArrayList<>();
        list.add(comando());
        Mockito.when(manejador.listar()).thenReturn(new ResponseEntity<>(list, null, HttpStatus.OK));
        ResponseEntity<List<ComandoTipoProducto>> response = controlador.listar();
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(comando().getCodigo(), response.getBody().get(0).getCodigo());
    }

    @Test
    public void testGetTipoProducto() {
        Mockito.when(manejador.getTipoProducto(1)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.OK));
        Mockito.when(manejador.existe(1)).thenReturn(true);
        ResponseEntity<?> response = controlador.getTipoProducto(1);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void testEliminarTipoProducto() {
        Mockito.when(manejador.eliminar(1)).thenReturn(new ResponseEntity<>(true, null, HttpStatus.OK));
        ResponseEntity<Boolean> response = controlador.eliminar(1);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(response.getBody());
    }

    @Test
    public void testRegistrarTipoProducto() {
        ComandoTipoProducto comando = comando();
        Mockito.when(manejador.guardar(comando)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.CREATED));
        ResponseEntity<ComandoTipoProducto> response = controlador.registrar(comando);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.CREATED));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(comando.getCodigo(), response.getBody().getCodigo());

    }

    @Test
    public void testActualizarCliente() {
        ComandoTipoProducto comando = comando();
        Mockito.when(manejador.actualizar(1, comando)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.CREATED));
        Mockito.when(manejador.existe(1)).thenReturn(true);
        ResponseEntity<?> response = controlador.actualizar(1, comando);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.CREATED));
        Assertions.assertNotNull(response.getBody());
    }

    private ComandoTipoProducto comando() {
        return new ComandoTipoProducto(1, "CC01", "Calzaddo", 25000.0);
    }
}