package com.saskiamou.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnknownCurrencyException.class)
    public ResponseEntity<Object> handleUnknownCurrencyException{
        UnknownCurrencyException e, WebRequest r) {

        }
    }

}