package ru.io6.demo.dto.Instrument;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstrumentDTO {
    private String isin;
    private String figi;
    private String ticker;
    private String classCode;
    private String instrumentType;
    private String name;
    private String uid;
    private String positionUid;
    private String instrumentKind;
    private boolean apiTradeAvailableFlag;
    private boolean forIisFlag;
    private String first1minCandleDate;
    private String first1dayCandleDate;
    private boolean forQualInvestorFlag;
    private boolean weekendFlag;
    private boolean blockedTcaFlag;
}
