package com.djhoyos.logistica.infraestructura.servicio;

import com.djhoyos.logistica.infraestructura.entidad.UsuarioPrincipal;
import com.djhoyos.logistica.infraestructura.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RepositorioUsuario repo;

    @Autowired
    public UserDetailsServiceImpl(RepositorioUsuario repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        return UsuarioPrincipal.build(repo.findByNombreUsuario(nombreUsuario).orElseThrow());
    }
}
