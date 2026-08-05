package com.saskiamou.api.service;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {
    private final Map<String, Double> rates = Map.of(
            "USD", 1.0,
            "EUR", 0.92,
            "GBP", 0.79
    );

    public double convert(String to, String from, double amount) {
        double amountInUsd = amount / rates.get(from);
        return amountInUsd * rates.get(to);
    }
}
