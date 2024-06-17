package ru.io6.demo.dto.marketData.orderBook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ru.io6.demo.dto.marketData.PriceDTO;

import java.util.List;

@Getter
@Setter
public class OrderBookDTO {
    private String figi;
    private int depth;
    private List<BidAskDTO> bids;
    private List<BidAskDTO> asks;
    private PriceDTO lastPrice;
    private PriceDTO closePrice;
    private PriceDTO limitUp;
    private PriceDTO limitDown;
    private String instrumentUid;
    private String lastPriceTs;
    private String closePriceTs;

    @JsonProperty("orderbookTs")
    private String orderBookTs;
}
