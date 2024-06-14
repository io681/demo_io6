package ru.io6.demo.dto.marketData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCandlesDTO {
    private String from;
    private String to;
    private final String interval = "CANDLE_INTERVAL_DAY";
    private String instrumentId;
    private final String candleSourceType = "CANDLE_SOURCE_EXCHANGE";
}
