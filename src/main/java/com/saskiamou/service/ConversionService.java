package com.saskiamou.service;

import com.saskiamou.dto.ConversionResponse;
// Interface declares method to be used in implementation file
public interface ConversionService {
    ConversionResponse convert(String from, String to, double amount);
}