package com.its.orientaTest.exceptions;

public class TipoTestInvalidoException extends RuntimeException {
    
    public TipoTestInvalidoException() {
        super("El tipo de test proporcionado es inválido");
    }

    public TipoTestInvalidoException(String message) {
        super(message);
    }
}
