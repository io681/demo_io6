package ru.io6.demo.dto.Instrument;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FindInstrumentsDTO {
    private List<InstrumentDTO> instruments;
}
