package ru.io6.demo.dto.marketData.orderBook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrderBookDTO {
    private final int depth = 50;
    private String instrumentId;
}
