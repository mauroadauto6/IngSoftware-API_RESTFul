package com.its.orientaTest.config;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice   devuelva el mensaje en un formato JSON y esto no  y el rest si
@AllArgsConstructor
@RestControllerAdvice
public class RestExceptionHanlder {
    private MessageSource messageSource;
    


}
