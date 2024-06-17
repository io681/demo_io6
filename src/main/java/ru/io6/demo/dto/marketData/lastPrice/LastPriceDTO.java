package ru.io6.demo.dto.marketData.lastPrice;

import lombok.Getter;
import lombok.Setter;
import ru.io6.demo.dto.marketData.PriceDTO;

@Getter
@Setter
public class LastPriceDTO {
    private String figi;
    private PriceDTO price;
    private String time;
    private String instrumentUid;
}
