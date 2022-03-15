package com.djhoyos.logistica.dominio.excepcion;

/**
 * Utilizada para identificar excepciones de dominio.
 */
public class ExcepcionDominio extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ExcepcionDominio(String mensaje){
    super(mensaje);
  }

}
