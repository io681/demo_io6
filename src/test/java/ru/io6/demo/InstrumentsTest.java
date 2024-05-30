package ru.io6.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.io6.demo.dto.instrument.FindInstrumentsDTO;
import ru.io6.demo.dto.instrument.InstrumentDTO;
import ru.io6.demo.service.InstrumentsService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
public class InstrumentsTest {
    @Autowired
    private InstrumentsService instrumentsService;

    @Test
    void showFindInstrumentTest() {
        FindInstrumentsDTO dto = new FindInstrumentsDTO();
        List<InstrumentDTO> instruments = new ArrayList<>();
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.setIsin("RU000A0JP5V6");
        instruments.add(instrumentDTO);
        dto.setInstruments(instruments);

        var expectedResult = instrumentsService
                .showFindInstrument("RU000A0JP5V6")
                .getInstruments()
                .get(0)
                .getIsin();
        assertThat(expectedResult).isEqualTo("RU000A0JP5V6");
    }
}
