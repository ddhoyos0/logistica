package com.djhoyos.logistica.dominio.modelo;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {
    private String troken;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String troken, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.troken = troken;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    public String getTroken() {
        return troken;
    }

    public void setTroken(String troken) {
        this.troken = troken;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
