package com.saskiamou.service;

import org.springframework.stereotype.Service;
import java.util.Locale;
import com.saskiamou.dto.ConversionResponse;
import com.saskiamou.dto.RatesDto;
import com.saskiamou.exception.UnknownCurrencyException;


@Service
public class ConversionServiceImpl implements ConversionService {
    ExchangeRateClient exchangeRateClient;

    public ConversionServiceImpl(ExchangeRateClient exchangeRateClient ) {
        this.exchangeRateClient = exchangeRateClient;
    }
    /** Convert method stores passed from/to/amnt params
     * convert entries to uppercase to avoid capitalization mismatch
     * ROOT Locale constant used as base identifier of country currency code. **/
    public ConversionResponse convert(String from, String to, double amount) {
        String base = from.toUpperCase(Locale.ROOT);
        String target = to.toUpperCase(Locale.ROOT);

        // Conditional returns unchanged currency if both params are equal (ex. USD to USD)
        if (base.equals(target)) {
            return new ConversionResponse(base, target, amount, 1.0, amount);
        }

        RatesDto rates = exchangeRateClient.getRates(base);
        Double toRate = rates.rates().get(target);
        if (toRate == null) {
            throw new UnknownCurrencyException(target);
        }
        return new ConversionResponse(base, target, amount, toRate, amount * toRate);
    }
}