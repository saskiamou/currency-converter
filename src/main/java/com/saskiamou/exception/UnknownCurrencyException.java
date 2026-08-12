package com.saskiamou.exception;

public class UnknownCurrencyException extends RuntimeException {

    public UnknownCurrencyException(String code) {
      super(String.format("Unknown currency: %s", code));
    }
}
