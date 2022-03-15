package com.djhoyos.logistica.dominio.validacion;

import com.djhoyos.logistica.dominio.excepcion.ExcepcionDominio;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidadorDominio {

    private static final String MENSAJE_ERROR = "El campo %s es obligatorio";
    private static final String MENSAJE_NUMERO_ERROR = "El campo %s no es un valor númerico valido";
    private static final String CORREO_INVALIDO = "El correo ingresado no es valido";

    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    protected void validarParametrosObligatorio(Object valor, String nombre) {
        if (ObjectUtils.isEmpty(valor)) {
            throw new ExcepcionDominio(String.format(MENSAJE_ERROR, nombre));
        }
    }
    protected void validarParametrosNumericos(int valor, String nombre) {
        if (valor <= 0) {
            throw new ExcepcionDominio(String.format(MENSAJE_NUMERO_ERROR, nombre));
        }
    }
    protected void validarParametrosDouble(Double valor, String nombre) {
        if (valor <= 0) {
            throw new ExcepcionDominio(String.format(MENSAJE_NUMERO_ERROR, nombre));
        }
    }
    protected void validarParametroTipoEmail(String valor) {
        if (!ObjectUtils.isEmpty(valor)) {
            Matcher mather = pattern.matcher(valor);
            if (!mather.find()) {
                throw new ExcepcionDominio(CORREO_INVALIDO);
            }
        }
    }
}
