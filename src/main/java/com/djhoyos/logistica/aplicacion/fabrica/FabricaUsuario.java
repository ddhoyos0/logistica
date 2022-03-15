package com.djhoyos.logistica.aplicacion.fabrica;

import com.djhoyos.logistica.aplicacion.comando.ComandoUsuario;
import com.djhoyos.logistica.dominio.enums.RolNombre;
import com.djhoyos.logistica.dominio.modelo.Usuario;
import com.djhoyos.logistica.infraestructura.entidad.EntidadRol;
import com.djhoyos.logistica.infraestructura.entidad.EntidadUsuario;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;

@Component
public final class FabricaUsuario {

    public FabricaUsuario() {
    }

    public static ComandoUsuario comando(EntidadUsuario entidad) {
        Set<String> roles = new HashSet<>();
        roles.add(entidad.getRoles().toString());
        return new ComandoUsuario(entidad.getNombre(), entidad.getNombreUsuario(), entidad.getCorreo(), entidad.getPassword(), roles);
    }

    public static EntidadUsuario modelo(Usuario entidad, Set<EntidadRol> rol) {
        return new EntidadUsuario(
                entidad.getNombre(),
                entidad.getNombreUsuario(),
                entidad.getCorreo(),
                entidad.getPassword(),
                rol
        );
    }

    public static Usuario modeloUsuario(ComandoUsuario comando) {
        Set<String> rol = new HashSet<>();
        rol.add(RolNombre.ROLE_USUARIO.name());
        if (!ObjectUtils.isEmpty(comando.getRoles()) && comando.getRoles().contains("admin")) {
            rol.add(RolNombre.ROLE_ADMINITRADOR.name());
        }
        rol.add(RolNombre.ROLE_USUARIO.name());
        return new Usuario(
                comando.getNombreUsuario(),
                comando.getNombreUsuario(),
                comando.getCorreo(),
                comando.getPassword(),
                rol);
    }
}
