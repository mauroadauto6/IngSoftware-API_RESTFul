package com.its.orientaTest.exception;

public class MaximoIntentosTestException extends RuntimeException {
    
    public MaximoIntentosTestException() {
        super("Se ha alcanzado el número máximo de intentos permitidos para realizar el test.");
    }

    public MaximoIntentosTestException(String message) {
        super(message);
    }
}
