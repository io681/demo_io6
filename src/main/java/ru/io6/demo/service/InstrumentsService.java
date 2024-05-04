package ru.io6.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.io6.demo.config.WebClientConfig;
import ru.io6.demo.dto.Instrument.FindInstrumentsDTO;
import ru.io6.demo.dto.Instrument.RequestFindInstrumentDTO;

@Service
public class InstrumentsService {
    private static final String URI_INSTRUMENTS_SERVICE = "/tinkoff.public.invest.api.contract.v1.InstrumentsService";
    @Autowired
    private WebClientConfig webClient;

    public FindInstrumentsDTO showFindInstrument(String queryText) {
        RequestFindInstrumentDTO requestFindInstrumentDTO = new RequestFindInstrumentDTO();
        requestFindInstrumentDTO.setQuery(queryText);

        return webClient.createWebCustomerClient()
                .post()
                .uri(URI_INSTRUMENTS_SERVICE + "/FindInstrument")
                .body(Mono.just(requestFindInstrumentDTO), RequestFindInstrumentDTO.class)
                .retrieve()
                .bodyToMono(FindInstrumentsDTO.class)
                .block();

    }
}
