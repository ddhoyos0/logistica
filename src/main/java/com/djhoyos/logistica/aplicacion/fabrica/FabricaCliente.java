package com.djhoyos.logistica.aplicacion.fabrica;

import com.djhoyos.logistica.aplicacion.comando.ComandoCliente;
import com.djhoyos.logistica.dominio.enums.TipoIdentificacion;
import com.djhoyos.logistica.dominio.modelo.Cliente;
import com.djhoyos.logistica.dominio.validacion.ValidarEnum;
import com.djhoyos.logistica.infraestructura.entidad.EntidadCliente;

public final class FabricaCliente {

    public FabricaCliente() {
    }

    public static ComandoCliente comando(EntidadCliente cliente) {
        return new ComandoCliente(
                cliente.getId(),
                cliente.getTipoIdentificacion().name(),
                cliente.getNumeroIdentificacion(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }

    public static ComandoCliente comandoCliente(Cliente cliente) {
        return new ComandoCliente(
                cliente.getId(),
                cliente.getTipoIdentificacion().name(),
                cliente.getNumeroIdentificacion(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }

    public static EntidadCliente entidadCliente(Cliente cliente) {
        return new EntidadCliente(
                cliente.getId(),
                cliente.getTipoIdentificacion(),
                cliente.getNumeroIdentificacion(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }

    public static EntidadCliente entidad(Cliente cliente) {
        return new EntidadCliente (
                cliente.getId(),
                cliente.getTipoIdentificacion(),
                cliente.getNumeroIdentificacion(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }

    public static Cliente modelo(ComandoCliente cliente) {
        return new Cliente(
                cliente.getId(),
                ValidarEnum.obtenerValor(TipoIdentificacion.class, cliente.getTipoIdentificacion(), "Tipo de identificación"),
                cliente.getNumeroIdentificacion(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }
    public static Cliente modelo(EntidadCliente cliente) {
        return new Cliente(
                cliente.getId(),
                cliente.getTipoIdentificacion(),
                cliente.getNumeroIdentificacion(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }
}
