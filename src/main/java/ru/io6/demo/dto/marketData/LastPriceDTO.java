package ru.io6.demo.dto.marketData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LastPriceDTO {
    private String figi;
    private PriceDTO price;
    private String time;
    private String instrumentUid;
}
