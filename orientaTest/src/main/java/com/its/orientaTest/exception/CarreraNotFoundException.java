package com.its.orientaTest.exception;

public class CarreraNotFoundException extends RuntimeException {
    
    public CarreraNotFoundException() {
        super("Carrera no encontrada.");
    }

    public CarreraNotFoundException(String message) {
        super(message);
    }
}
