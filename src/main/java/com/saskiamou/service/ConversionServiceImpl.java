package com.saskiamou.service;
import com.saskiamou.dto.RatesDto;
import com.saskiamou.exception.UnknownCurrencyException;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {
    ExchangeRateClient exchangeRateClient;

    public ConversionServiceImpl(ExchangeRateClient exchangeRateClient ) {
        this.exchangeRateClient = exchangeRateClient;
    }

    public double convert(String from, String to, double amount) {
        String base = from.toUpperCase(Locale.ROOT);
        String target = to.toUpperCase(Locale.ROOT);

        if (base.equals(target)) {
            return amount;
        }

        RatesDto rates = exchangeRateClient.getRates(base);
        Double toRate = rates.rates().get(target);
        if (toRate == null) {
            throw new UnknownCurrencyException(target);
        }
        return amount * toRate;
    }
}