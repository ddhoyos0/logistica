package com.djhoyos.logistica.infraestructura.configuracion;

import com.djhoyos.logistica.dominio.repositorio.IRepositorioCliente;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioDespacho;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioRol;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioTipoProducto;
import com.djhoyos.logistica.dominio.repositorio.IRepositorioUsuario;
import com.djhoyos.logistica.dominio.servicio.ServicioCliente;
import com.djhoyos.logistica.dominio.servicio.ServicioDespacho;
import com.djhoyos.logistica.dominio.servicio.ServicioTipoProducto;
import com.djhoyos.logistica.dominio.servicio.ServicioUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Beans {

    @Bean
    public ServicioUsuario servicioUsuario(IRepositorioUsuario repositorioUsuario, IRepositorioRol repositorioRol) {
        return new ServicioUsuario(repositorioUsuario, repositorioRol);
    }

    @Bean
    public ServicioCliente servicioCliente(IRepositorioCliente repo) {
        return new ServicioCliente(repo);
    }

    @Bean
    public ServicioDespacho servicioDespacho(IRepositorioDespacho repo) {
        return new ServicioDespacho(repo);
    }

    @Bean
    public ServicioTipoProducto servicioTipoProducto(IRepositorioTipoProducto repo) {
        return new ServicioTipoProducto(repo);
    }
}
