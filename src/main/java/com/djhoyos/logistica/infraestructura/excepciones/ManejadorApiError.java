package com.djhoyos.logistica.infraestructura.excepciones;

import com.djhoyos.logistica.dominio.excepcion.ExcepcionDominio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.concurrent.CompletionException;

@ControllerAdvice
public class ManejadorApiError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request) {
        ApiError excepResp = new ApiError(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(excepResp, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({ExcepcionDominio.class})
    public final ResponseEntity<Object> manejarExcepcionValorNoEncontrado(Exception ex, WebRequest request) {
        ApiError excepResp = new ApiError(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(excepResp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CompletionException.class)
    public final ResponseEntity<Object> manejarExcepcionCompletableFuture(Exception ex, WebRequest request) {
        ApiError excepResp = new ApiError(LocalDateTime.now(), ex.getCause().getMessage(), request.getDescription(false));
        return new ResponseEntity<>(excepResp, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder bld = new StringBuilder();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            bld.append(error.getDefaultMessage());
        }
        String errores = bld.toString();
        ApiError excepResp = new ApiError(LocalDateTime.now(), "validacion fallida", errores);
        return new ResponseEntity<>(excepResp, HttpStatus.BAD_REQUEST);
    }

}
