package com.djhoyos.logistica.infraestructura.entidad;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String nombreUsuario;
    private String correo;
    private String password;
    private Collection<? extends GrantedAuthority> autorizado;

    public UsuarioPrincipal(String nombre, String nombreUsuario, String correo, String password, Collection<? extends GrantedAuthority> autorizado) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
        this.autorizado = autorizado;
    }

    public static UsuarioPrincipal build(EntidadUsuario usuario) {
        List<GrantedAuthority> autorizado = usuario.getRoles()
                .stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getCorreo(),usuario.getPassword(), autorizado);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizado;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
