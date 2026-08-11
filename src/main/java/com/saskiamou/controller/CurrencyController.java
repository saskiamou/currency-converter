package com.saskiamou.controller;
import com.saskiamou.service.ConversionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyController {
    // Dependency injection
    private final ConversionService conversionService;
    public CurrencyController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert")
    public double convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
                return conversionService.convert(from, to, amount);
    }
}
