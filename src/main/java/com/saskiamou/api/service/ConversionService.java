package com.saskiamou.api.service;
import com.saskiamou.api.model.ConversionRequest;

public interface ConversionService {
    double convert(String to, String from, double amount);
}
