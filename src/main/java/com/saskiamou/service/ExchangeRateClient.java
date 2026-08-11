package com.saskiamou.service;

import com.saskiamou.dto.RatesDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
class ExchangeRateClient {
    RestClient customClient = RestClient.builder()
            .baseUrl("https://api.frankfurter.dev/v1").build();
    public RatesDto getRates(String base) {
        return customClient.get().uri("/latest?base={base}", base)
                .retrieve()
                .body(RatesDto.class);
    }

}
