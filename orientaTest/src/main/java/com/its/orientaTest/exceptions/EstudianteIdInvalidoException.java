package com.its.orientaTest.exceptions;

public class EstudianteIdInvalidoException extends RuntimeException {
    
    public EstudianteIdInvalidoException() {
        super("El ID del estudiante proporcionado es inválido");
    }

    public EstudianteIdInvalidoException(String message) {
        super(message);
    }
}
