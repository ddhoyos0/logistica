package com.djhoyos.logistica.infraestructura.configuracion.jwt;

import com.djhoyos.logistica.infraestructura.servicio.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFiltrarToken extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtFiltrarToken.class);

    @Autowired
    private JwtProveedor proveedor;

    @Autowired
    private UserDetailsServiceImpl servicio;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(req);
            if (!ObjectUtils.isEmpty(token) && proveedor.validarToken(token)) {
                String nombreUsuario = proveedor.optenerNombreUsuarioToken(token);
                UserDetails userDetails = servicio.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error("Fallo el metodo doFilter");
        }
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (!ObjectUtils.isEmpty(header) && header.startsWith("Bearer")) {
            return header.replace("Bearer", "");
        }
        return null;
    }
}
