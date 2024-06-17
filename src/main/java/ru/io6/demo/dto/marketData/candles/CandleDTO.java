package ru.io6.demo.dto.marketData.candles;

import lombok.Getter;
import lombok.Setter;
import ru.io6.demo.dto.marketData.PriceDTO;

@Getter
@Setter
public class CandleDTO {
    private PriceDTO open;
    private PriceDTO high;
    private PriceDTO low;
    private PriceDTO close;
    private String volume;
    private String time;
    private boolean isComplete;
    private String candleSource;
}
