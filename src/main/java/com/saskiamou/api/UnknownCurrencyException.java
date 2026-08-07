package com.saskiamou.api;

public class UnknownCurrencyException extends RuntimeException {
    private String message;
    public UnknownCurrencyException(String message) {
        super(message);
        this.message = message;
    }
}
