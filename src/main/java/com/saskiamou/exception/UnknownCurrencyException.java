package com.saskiamou.exception;
// Custom exception, currency code passed as param
public class UnknownCurrencyException extends RuntimeException {

    public UnknownCurrencyException(String code) {
      super(String.format("Unknown currency: %s", code));
    }
}
