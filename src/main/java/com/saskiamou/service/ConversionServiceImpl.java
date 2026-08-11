package com.saskiamou.service;
import com.saskiamou.dto.RatesDto;
import com.saskiamou.exception.UnknownCurrencyException;

import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {
    ExchangeRateClient exchangeRateClient;

    public ConversionServiceImpl(ExchangeRateClient exchangeRateClient ) {
        this.exchangeRateClient = exchangeRateClient;
    }


    public double convert(String from, String to, double amount) {
        RatesDto rates = exchangeRateClient.getRates(from);
        Double toRate = rates.rates().get(to);
        if (toRate == null) {
            throw new UnknownCurrencyException(from, to);
        }
            return amount * toRate;
    }



}