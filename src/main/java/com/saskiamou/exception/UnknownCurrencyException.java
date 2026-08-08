package com.saskiamou.exception;

public class UnknownCurrencyException extends RuntimeException {

    public UnknownCurrencyException(String from, String to) {
      super(String.format("Unknown currency - from: %s, to: %s", from, to));
    }
}
