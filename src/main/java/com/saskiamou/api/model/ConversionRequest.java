package com.saskiamou.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionRequest {
    private double amount;
    private String firstCurrency;
    private String secondCurrency;


    public ConversionRequest(double amount, String firstCurrency, String secondCurrency) {
        this.amount = amount;
        this.firstCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
    }

}
