package com.djhoyos.logistica.aplicacion.fabrica;

import com.djhoyos.logistica.aplicacion.comando.ComandoTipoProducto;
import com.djhoyos.logistica.dominio.modelo.TipoProducto;
import com.djhoyos.logistica.infraestructura.entidad.EntidadTipoProducto;
import org.springframework.stereotype.Component;

@Component
public final class FabricaTipoProducto {

    public FabricaTipoProducto() {
    }

    public static ComandoTipoProducto comando(TipoProducto producto) {
        return new ComandoTipoProducto(producto.getId(), producto.getCodigo(), producto.getNombre(), producto.getPrecio());
    }

    public static EntidadTipoProducto entidadTipoProducto(TipoProducto producto) {
        return new EntidadTipoProducto(producto.getId(), producto.getCodigo(), producto.getNombre(), producto.getPrecio());
    }

    public static TipoProducto modelo(ComandoTipoProducto comando) {
        return new TipoProducto(comando.getId(), comando.getCodigo(), comando.getNombre(), comando.getPrecio());
    }

    public static ComandoTipoProducto entidad(EntidadTipoProducto entidad) {
        return new ComandoTipoProducto(entidad.getId(), entidad.getCodigo(), entidad.getNombre(), entidad.getPrecio());
    }
}
