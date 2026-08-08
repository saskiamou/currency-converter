package com.saskiamou.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Map;

@ConfigurationProperties(prefix = "currency")
public record ConversionProperties(Map<String, Double> rates) {}
