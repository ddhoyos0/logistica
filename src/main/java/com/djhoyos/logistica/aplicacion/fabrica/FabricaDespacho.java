package com.djhoyos.logistica.aplicacion.fabrica;

import com.djhoyos.logistica.aplicacion.comando.ComandoDespacho;
import com.djhoyos.logistica.dominio.enums.TipoEnvio;
import com.djhoyos.logistica.dominio.modelo.Despacho;
import com.djhoyos.logistica.dominio.validacion.ValidarEnum;
import com.djhoyos.logistica.infraestructura.entidad.EntidadDespacho;
import org.springframework.stereotype.Component;

@Component
public final class FabricaDespacho {

    public FabricaDespacho() {
    }

    public static ComandoDespacho comando(Despacho despacho) {
        return new ComandoDespacho(
                despacho.getId(),
                despacho.getTipoEnvio().name(),
                FabricaTipoProducto.comando(despacho.getTipoProducto()),
                despacho.getCantidad(),
                despacho.getFechaRegistro(),
                despacho.getFechaEntrega(),
                despacho.getLugarEntrega(),
                despacho.getPrecio(),
                despacho.getPlaca(),
                despacho.getNumeroGuia(),
                despacho.getDescuento(),
                FabricaCliente.comandoCliente(despacho.getCliente())

        );
    }

    public static Despacho modelo(ComandoDespacho comando) {
        return new Despacho(
                comando.getId(),
                ValidarEnum.obtenerValor(TipoEnvio.class, comando.getTipoEnvio(), "Tipo de Envio"),
                FabricaTipoProducto.modelo(comando.getTipoProducto()),
                comando.getCantidad(),
                comando.getFechaRegistro(),
                comando.getFechaEntrega(),
                comando.getLugarEntrega(),
                comando.getPrecio(),
                comando.getPlaca(),
                comando.getNumeroGuia(),
                comando.getDescuento(),
                FabricaCliente.modelo(comando.getCliente())
        );
    }

    public static ComandoDespacho entidad(EntidadDespacho entidad) {
        return new ComandoDespacho(
                entidad.getId(),
                entidad.getTipoEnvio().name(),
                FabricaTipoProducto.entidad(entidad.getTipoProducto()),
                entidad.getCantidad(),
                entidad.getFechaRegistro(),
                entidad.getFechaEntrega(),
                entidad.getLugarEntrega(),
                entidad.getPrecio(),
                entidad.getPlaca(),
                entidad.getNumeroGuia(),
                entidad.getDescuento(),
                FabricaCliente.comando(entidad.getCliente())
        );
    }
}
