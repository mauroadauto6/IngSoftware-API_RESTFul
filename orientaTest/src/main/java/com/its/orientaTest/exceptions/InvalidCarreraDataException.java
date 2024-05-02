package com.its.orientaTest.exceptions;

public class InvalidCarreraDataException extends RuntimeException {
    
    public InvalidCarreraDataException() {
        super("Datos de carrera inválidos.");
    }

    public InvalidCarreraDataException(String message) {
        super(message);
    }
}
