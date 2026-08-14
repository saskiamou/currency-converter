package com.saskiamou.exception;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.context.MessageSourceResolvable;


@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UnknownCurrencyException.class)
    public ResponseEntity<String>
    handleUnknownCurrencyException(UnknownCurrencyException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<String>
    handleValidationException(HandlerMethodValidationException e) {
        String message = e.getParameterValidationResults().stream()
                .map(result -> {
                    String name = result.getMethodParameter().getParameterName();
                    String errors = result.getResolvableErrors().stream()
                            .map(MessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.joining(", "));
                    return name + ": " + errors;
                })
                .collect(Collectors.joining("; "));
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}