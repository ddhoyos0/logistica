package com.djhoyos.logistica.infraestructura.controladores;

import com.djhoyos.logistica.aplicacion.comando.ComandoMensaje;
import com.djhoyos.logistica.aplicacion.comando.ComandoUsuario;
import com.djhoyos.logistica.aplicacion.manejador.ManejadorUsuario;
import com.djhoyos.logistica.dominio.modelo.JwtDto;
import com.djhoyos.logistica.dominio.modelo.Login;
import com.djhoyos.logistica.infraestructura.configuracion.jwt.JwtProveedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@CrossOrigin
public class ControladorUsuario {


    private AuthenticationManager authenticationManager;
    private ManejadorUsuario manejador;
    private JwtProveedor proveedor;
    private PasswordEncoder passwordEncoder;

    public ControladorUsuario(AuthenticationManager authenticationManager, ManejadorUsuario manejador, JwtProveedor proveedor, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.manejador = manejador;
        this.proveedor = proveedor;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@Validated @RequestBody ComandoUsuario comando, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ComandoMensaje("Campos incorrectos!!"), HttpStatus.BAD_REQUEST);
        }
        if (Boolean.TRUE.equals(manejador.existeNombreUsuario(comando.getNombreUsuario()).getBody())) {
            return new ResponseEntity<>(new ComandoMensaje("El nombre de usuario ya existe!!"), HttpStatus.BAD_REQUEST);
        }
        if (Boolean.TRUE.equals(manejador.existeCorreo(comando.getCorreo()).getBody())) {
            return new ResponseEntity<>(new ComandoMensaje("El correo ya existe!!"), HttpStatus.BAD_REQUEST);
        }
        String password = passwordEncoder.encode(comando.getPassword());
        comando.setPassword(password);
        return new ResponseEntity<>(manejador.registrarUsuario(comando), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody Login comando, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ComandoMensaje("Campos incorrectos!!"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                comando.getNombreUsuario(), comando.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = proveedor.generarToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>(new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities()), HttpStatus.OK);
    }
}
