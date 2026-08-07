package com.saskiamou.Exception;

public class UnknownCurrencyException extends RuntimeException {

    public UnknownCurrencyException(String from, String to) {
      super(String.format("Unknown currency: %s, %s", to, from));
    }
}
