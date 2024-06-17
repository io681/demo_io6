package ru.io6.demo.dto.marketData.candles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CandlesDTO {
    private List<CandleDTO> candles;
}
