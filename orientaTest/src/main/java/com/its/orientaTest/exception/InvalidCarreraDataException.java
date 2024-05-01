package com.its.orientaTest.exception;

public class InvalidCarreraDataException extends RuntimeException {
    
    public InvalidCarreraDataException() {
        super("Datos de carrera inválidos.");
    }

    public InvalidCarreraDataException(String message) {
        super(message);
    }
}
