package com.saskiamou.Exception;

public class UnknownCurrencyException extends RuntimeException {
    private String message;
    public UnknownCurrencyException(String message) {
        super(message);
        this.message = message;
    }
}
