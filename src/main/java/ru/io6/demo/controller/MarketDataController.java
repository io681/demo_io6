package ru.io6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.io6.demo.dto.marketData.LastPricesDTO;
import ru.io6.demo.dto.marketData.RequestGetLastPricesDTO;
import ru.io6.demo.service.MarketDataService;


@RestController
@RequestMapping("api/marketData")
public class MarketDataController {
    @Autowired
    private MarketDataService marketDataService;

    @PostMapping(path = "/getLastPrices")
    public LastPricesDTO showLastPrices(@RequestBody RequestGetLastPricesDTO dto) {
        return marketDataService.showLastPrices(dto.getInstrumentIds());
    }
}
