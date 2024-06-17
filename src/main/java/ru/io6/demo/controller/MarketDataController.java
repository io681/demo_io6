package ru.io6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.io6.demo.dto.marketData.candles.CandlesDTO;
import ru.io6.demo.dto.marketData.lastPrice.LastPricesDTO;
import ru.io6.demo.dto.marketData.candles.RequestCandlesDTO;
import ru.io6.demo.dto.marketData.lastPrice.RequestGetLastPricesDTO;
import ru.io6.demo.dto.marketData.orderBook.OrderBookDTO;
import ru.io6.demo.dto.marketData.orderBook.RequestOrderBookDTO;
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

    @PostMapping(path = "/getCandles")
    public CandlesDTO showCandles(@RequestBody RequestCandlesDTO dto) {
        return marketDataService.showCandles(dto.getFrom(), dto.getTo(), dto.getInstrumentId());
    }

    @PostMapping(path = "/getOrderBook")
    public OrderBookDTO showOrderBook(@RequestBody RequestOrderBookDTO dto) {
        return marketDataService.showOrderBook(dto.getInstrumentId());
    }
}
