package com.its.orientaTest.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.its.orientaTest.exceptions.CarreraNotFoundException;
import com.its.orientaTest.exceptions.CorreoElectronicoEnUsoException;
import com.its.orientaTest.exceptions.EstudianteNotFoundException;
import com.its.orientaTest.exceptions.InvalidCarreraDataException;
import com.its.orientaTest.exceptions.MaximoIntentosTestException;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EstudianteNotFoundException.class)
    public ResponseEntity<String> handleEstudianteNotFoundException(EstudianteNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CorreoElectronicoEnUsoException.class)
    public ResponseEntity<String> handleCorreoElectronicoEnUsoException(CorreoElectronicoEnUsoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaximoIntentosTestException.class)
    public ResponseEntity<String> handleMaximoIntentosTestException(MaximoIntentosTestException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
     @ExceptionHandler(CarreraNotFoundException.class)
    public ResponseEntity<String> handleCarreraNotFoundException(CarreraNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCarreraDataException.class)
    public ResponseEntity<String> handleInvalidCarreraDataException(InvalidCarreraDataException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
