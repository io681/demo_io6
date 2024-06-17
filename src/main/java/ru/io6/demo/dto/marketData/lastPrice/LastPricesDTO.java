package ru.io6.demo.dto.marketData.lastPrice;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LastPricesDTO {
    private List<LastPriceDTO> lastPrices;
}
