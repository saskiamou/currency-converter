package com.saskiamou.controller;
// Controller communicates with Service
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

    // Convert method handles HTTP GET request sent to /convert URL
    // Starting currency code, target currency code and amount are passed as params to be converted in Service layer.
    @GetMapping("/convert")
    public double convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
                return conversionService.convert(from, to, amount);
    }
}
