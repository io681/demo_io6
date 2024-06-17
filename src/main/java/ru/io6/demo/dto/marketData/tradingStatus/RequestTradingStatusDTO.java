package ru.io6.demo.dto.marketData.tradingStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTradingStatusDTO {
    private String figi;
    private String instrumentId;
}
