package com.saskiamou.api.model;

public class ConversionRequest {
    private double amount;
    private String firstCurrency;
    private String secondCurrency;

    public ConversionRequest() {
    }

    public ConversionRequest(double amount, String firstCurrency, String secondCurrency) {
        this.amount = amount;
        this.firstCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getFirstCurrency() {
        return firstCurrency;
    }
    public void setFirstCurrency(String firstCurrency) {
        this.firstCurrency = firstCurrency;
    }
    public String getSecondCurrency() {
        return secondCurrency;
    }
    public void setSecondCurrency(String secondCurrency) {
        this.secondCurrency= secondCurrency;
    }


}
