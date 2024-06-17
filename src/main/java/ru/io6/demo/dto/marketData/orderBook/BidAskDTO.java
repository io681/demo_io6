package ru.io6.demo.dto.marketData.orderBook;

import lombok.Getter;
import lombok.Setter;
import ru.io6.demo.dto.marketData.PriceDTO;

@Getter
@Setter
public class BidAskDTO {
    private PriceDTO price;
    private int quantity;
}
