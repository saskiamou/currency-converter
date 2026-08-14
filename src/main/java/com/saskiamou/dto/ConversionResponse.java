package com.saskiamou.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Result of a currency conversion")
public record ConversionResponse(
        @Schema(description = "Base currency code", example = "USD")
        String from,

        @Schema(description = "Target currency code", example = "EUR")
        String to,

        @Schema(description = "Orginal amount to be converted", example = "100")
        double amount,

        @Schema(description = "Exchange rate to be applied - from base to target", example = "0.86453")
        double rate,

        @Schema(description = "Converted amount", example = "86.453")
        double result
) {
}
