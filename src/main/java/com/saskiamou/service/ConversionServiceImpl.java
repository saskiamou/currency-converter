package com.saskiamou.service;
import com.saskiamou.Exception.UnknownCurrencyException;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {
    private final Map<String, Double> rates = Map.of(
            "USD", 1.0, //  Eventually update to a changing exchg rate, for variables to store and compute
            "EUR", 0.92,
            "GBP", 0.79
    );

    /** Convert  method - get() rate keys/values from Map. If null value throw exception
    else store and return amount calculation
     **/
    public double convert(String from, String to, double amount) {
        Double fromRate = rates.get(from);
        Double toRate = rates.get(to);
        if (fromRate == null || toRate == null) {
            throw new UnknownCurrencyException(from, to);
        }
            double convertedAmt = amount / fromRate;
            return convertedAmt * toRate;
    }
}