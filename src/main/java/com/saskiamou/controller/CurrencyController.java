package com.saskiamou.controller;
// Controller communicates with Service
import com.saskiamou.service.ConversionService;
import com.saskiamou.dto.ConversionResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

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
    public ConversionResponse convert(
            @RequestParam @Pattern(regexp = "[A-Za-z]{3}")
            String from,
            @RequestParam @Pattern(regexp = "[A-Za-z]{3}")
            String to,
            @RequestParam @Positive double amount) {
                return conversionService.convert(from, to, amount);
    }
}
