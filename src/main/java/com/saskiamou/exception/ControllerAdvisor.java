package com.saskiamou.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UnknownCurrencyException.class)
    public ResponseEntity<String>
    handleUnknownCurrencyException(UnknownCurrencyException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}