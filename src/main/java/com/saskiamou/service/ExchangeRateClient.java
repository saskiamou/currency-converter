package com.saskiamou.service;

import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.HttpClientErrorException;
import com.saskiamou.exception.UnknownCurrencyException;
import com.saskiamou.dto.RatesDto;

@Component
class ExchangeRateClient {
    RestClient customClient = RestClient.builder()
            .baseUrl("https://api.frankfurter.dev/v1")
            .build();
    @Cacheable("ratesCache")
    public RatesDto getRates(String base) {
        try {
            return customClient.get()
                    .uri("/latest?base={base}", base)
                    .retrieve()
                    .body(RatesDto.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new UnknownCurrencyException(base);
        }
    }

}
