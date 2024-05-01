package com.its.orientaTest.exceptions;

public class EstudianteNotFoundException extends RuntimeException {
    
    public EstudianteNotFoundException() {
        super("Estudiante no encontrado.");
    }

    public EstudianteNotFoundException(String message) {
        super(message);
    }
}
