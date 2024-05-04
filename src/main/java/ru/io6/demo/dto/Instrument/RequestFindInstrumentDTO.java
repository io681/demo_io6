package ru.io6.demo.dto.Instrument;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestFindInstrumentDTO {
    private String query;
    private final String instrumentKind = "INSTRUMENT_TYPE_SHARE";
    private final boolean apiTradeAvailableFlag = true;
}
