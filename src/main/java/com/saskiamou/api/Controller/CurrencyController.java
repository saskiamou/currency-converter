package com.saskiamou.api.Controller;
import com.saskiamou.api.model.ConversionRequest;
import com.saskiamou.api.service.ConversionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyController {
    // Dependency injection
    private final ConversionService conversionService;
    public CurrencyController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping
    public double convert(
            @RequestParam String to,
            @RequestParam String from,
            @RequestParam double amount) {
                return conversionService.convert(to, from, amount);
    }
}
