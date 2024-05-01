package com.its.orientaTest.exception;

public class CorreoElectronicoEnUsoException extends RuntimeException {
    
    public CorreoElectronicoEnUsoException() {
        super("El correo electrónico ya está en uso.");
    }

    public CorreoElectronicoEnUsoException(String message) {
        super(message);
    }
}
