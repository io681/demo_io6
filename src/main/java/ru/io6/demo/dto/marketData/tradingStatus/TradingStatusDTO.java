package ru.io6.demo.dto.marketData.tradingStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradingStatusDTO {
    private String figi;
    private String tradingStatus;
    private boolean limitOrderAvailableFlag;
    private boolean marketOrderAvailableFlag;
    private boolean apiTradeAvailableFlag;
    private String instrumentUid;

    @JsonProperty("bestpriceOrderAvailableFlag")
    private boolean bestPriceOrderAvailableFlag;

    private boolean onlyBestPrice;
}
