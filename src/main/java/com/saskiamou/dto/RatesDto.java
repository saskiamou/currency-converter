package com.saskiamou.dto;

import java.time.LocalDate;
import java.util.Map;

public record RatesDto(double amount, String base, LocalDate date, Map<String, Double> rates) {
}