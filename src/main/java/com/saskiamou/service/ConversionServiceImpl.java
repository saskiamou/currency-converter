package com.saskiamou.service;
import com.saskiamou.config.ConversionProperties;
import com.saskiamou.exception.UnknownCurrencyException;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {
    private final ConversionProperties conversionProperties;

    public ConversionServiceImpl(ConversionProperties conversionProperties) {
        this.conversionProperties = conversionProperties;
    }


    /** Convert  method - get() rate keys/values from Map. If null value throw exception
    else store and return amount calculation
     **/
    public double convert(String from, String to, double amount) {
        Double fromRate = conversionProperties.rates().get(from);
        Double toRate = conversionProperties.rates().get(to);
        if (fromRate == null || toRate == null) {
            throw new UnknownCurrencyException(from, to);
        }
            double convertedAmt = amount / fromRate;
            return convertedAmt * toRate;
    }
}