package com.djhoyos.logistica.dominio.validacion;

import com.djhoyos.logistica.dominio.enums.TipoEnvio;
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
    private static final String MENSAJE_PLACA = "formato placa no valido";

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

    protected void validarPlaca(String placa, TipoEnvio envio) {
        switch (envio) {
            case MARITIMO:
                if (placa.length() != 7 || !placa.substring(0, 2).matches("[A-Z]*") || placa.substring(3).matches("[0-9]*"))
                    throw new ExcepcionDominio(MENSAJE_PLACA);
            case TERRESTRE:
                if (placa.length() != 6 || !placa.substring(0, 2).matches("[A-Z]*") || placa.substring(3).matches("[0-9]*"))
                    throw new ExcepcionDominio(MENSAJE_PLACA);
        }
    }

}
