package com.its.orientaTest.exceptions;

public class FechaTestInvalidaException extends RuntimeException {
    
    public FechaTestInvalidaException() {
        super("La fecha de test proporcionada es inválida");
    }

    public FechaTestInvalidaException(String message) {
        super(message);
    }
}
