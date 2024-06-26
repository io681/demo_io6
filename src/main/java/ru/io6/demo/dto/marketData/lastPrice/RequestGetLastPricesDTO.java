package ru.io6.demo.dto.marketData.lastPrice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestGetLastPricesDTO {
    @JsonProperty("instrumentId")
    private List<String> instrumentIds;
}
