package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorDespacho;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class ControladorDespachoTest {

    @InjectMocks
    private ControladorDespacho controlador;

    @Mock
    private ManejadorDespacho manejador;

    @Test
    void registrar() {
        ComandoDespacho comando = comando();
        Mockito.when(manejador.guardar(comando)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.CREATED));
        ResponseEntity<ComandoDespacho> response = controlador.registrar(comando);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.CREATED));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(comando.getNumeroGuia(), response.getBody().getNumeroGuia());

    }

    @Test
    void listar() {
        List<ComandoDespacho> list = new ArrayList<>();
        list.add(comando());
        Mockito.when(manejador.listar()).thenReturn(new ResponseEntity<>(list, null, HttpStatus.OK));
        ResponseEntity<List<ComandoDespacho>> response = controlador.listar();
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(comando().getNumeroGuia(), response.getBody().get(0).getNumeroGuia());
    }

    @Test
    void eliminar() {
        Mockito.when(manejador.eliminar(1)).thenReturn(new ResponseEntity<>(true, null, HttpStatus.OK));
        ResponseEntity<Boolean> response = controlador.eliminar(1);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(response.getBody());
    }

    @Test
    void getCliente() {
        Mockito.when(manejador.getDespacho(1)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.OK));
        Mockito.when(manejador.existe(1)).thenReturn(true);
        ResponseEntity<?> response = controlador.getDespacho(1);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.OK));
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    void actualizar() {
        ComandoDespacho comando = comando();
        Mockito.when(manejador.actualizar(1, comando)).thenReturn(new ResponseEntity<>(comando(), null, HttpStatus.CREATED));
        Mockito.when(manejador.existe(1)).thenReturn(true);
        ResponseEntity<?> response = controlador.actualizar(1, comando);
        assertThat(HttpStatus.valueOf(response.getStatusCodeValue()), is(HttpStatus.CREATED));
        Assertions.assertNotNull(response.getBody());

    }

    private ComandoTipoProducto comandoProducto() {
        return new ComandoTipoProducto(1, "CC01", "Calzaddo", 25000.0);
    }

    private ComandoCliente comandoCliente() {
        return new ComandoCliente(1, "CC", "106675421", "Jorge", "Calle 64 58-32", "777777", "3126548978", "jorge@gmail.com");
    }

    private ComandoDespacho comando() {
        return new ComandoDespacho(
                1,
                "TERRESTRE",
                comandoProducto(),
                1,
                LocalDateTime.now(),
                LocalDate.now(),
                "Medellin",
                25000.0,
                "TMX456",
                "455454654",
                0.0,
                comandoCliente()
        );
    }

}