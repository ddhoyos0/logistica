package com.djhoyos.logistica.dominio.validacion;

import com.djhoyos.logistica.dominio.excepcion.ExcepcionDominio;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class ValidarEnum {

    private static final String MENSAJE_ERROR_ENUM = "para el campo %s debe enviar un valor que pertenezca al grupo [%s]";

    public static <T extends Enum<T>> T obtenerValor(Class<T> enumeracion, String valorAEvaluar, String nombreDelCampoAEvaluar) {
        for (T campo : enumeracion.getEnumConstants()) {
            if (campo.name().equals(valorAEvaluar)) {
                return campo;
            }
        }
        String valoresAceptados = Arrays.stream(enumeracion.getEnumConstants()).map(Enum::name).collect(Collectors.joining(", "));
        throw new ExcepcionDominio(String.format(MENSAJE_ERROR_ENUM, nombreDelCampoAEvaluar, valoresAceptados));
    }
}
