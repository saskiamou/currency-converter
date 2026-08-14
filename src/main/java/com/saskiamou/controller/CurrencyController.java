package com.saskiamou.controller;
// Controller communicates with Service
import com.saskiamou.service.ConversionService;
import com.saskiamou.dto.ConversionResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@RestController
public class CurrencyController {
    // Dependency injection
    private final ConversionService conversionService;
    public CurrencyController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Operation(
            summary = "Convert an amount between two currencies",
            description = "Fetches the latest rates from Frankfurter and returns the converted amount."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Conversion successed",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ConversionResponse.class))
            )
    @ApiResponse(
            responseCode = "400",
            description = "The currency code is not three letters, the amount is not positive, "
                    + "or the currency is not supported by Frankfurter.",
            content = @Content(
                    mediaType = "text/plain",
                    schema = @Schema(implementation = String.class))
    )
    @GetMapping("/convert")
    public ConversionResponse convert(
            @RequestParam
            @Pattern(regexp = "[A-Za-z]{3}")
            @Parameter(
                    description = "Base currency code (ISO 4217)",
                    example = "USD")
            String from,

            @RequestParam
            @Pattern(regexp = "[A-Za-z]{3}")
            @Parameter(
                    description = "Target currency code (ISO 4217)",
                    example = "EUR")
            String to,

            @RequestParam
            @Positive
            @Parameter(
                    description = "Amount to convert - must be positive",
                    example = "100")
            double amount) {
                return conversionService.convert(from, to, amount);
    }
}
