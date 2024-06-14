package ru.io6.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.io6.demo.config.WebClientConfig;
import ru.io6.demo.dto.marketData.CandlesDTO;
import ru.io6.demo.dto.marketData.LastPricesDTO;
import ru.io6.demo.dto.marketData.RequestCandlesDTO;
import ru.io6.demo.dto.marketData.RequestGetLastPricesDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketDataService {
    private static final String URI_MARKET_DATA_SERVICE = ".MarketDataService";
    @Autowired
    private WebClientConfig webClient;

    public LastPricesDTO showLastPrices(List<String> instrumentIds) {
        RequestGetLastPricesDTO dto = new RequestGetLastPricesDTO();
        dto.setInstrumentIds(new ArrayList<>());
        dto.getInstrumentIds().addAll(instrumentIds);

        return webClient.createWebCustomerClient()
                .post()
                .uri(URI_MARKET_DATA_SERVICE + "/GetLastPrices")
                .body(Mono.just(dto), RequestGetLastPricesDTO.class)
                .retrieve()
                .bodyToMono(LastPricesDTO.class)
                .block();
    }

    public CandlesDTO showCandles(String from, String to, String instrumentId) {
        RequestCandlesDTO dto = new RequestCandlesDTO();
        dto.setFrom(from);
        dto.setTo(to);
        dto.setInstrumentId(instrumentId);

        return webClient.createWebCustomerClient()
                .post()
                .uri(URI_MARKET_DATA_SERVICE + "/GetCandles")
                .body(Mono.just(dto), RequestCandlesDTO.class)
                .retrieve()
                .bodyToMono(CandlesDTO.class)
                .block();
    }
}
