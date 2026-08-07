package com.saskiamou.Exception;

public class UnknownCurrencyException extends RuntimeException {

    public UnknownCurrencyException(String to, String from) {
      super(String.format("Unknown currency: %s, %s", to, from));
    }
}
