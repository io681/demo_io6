package ru.io6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import ru.io6.demo.dto.instrument.FindInstrumentsDTO;
import ru.io6.demo.service.InstrumentsService;

@RestController
@RequestMapping("api/instruments")
public class InstrumentsController {
    @Autowired
    private InstrumentsService  instrumentsService;

    @GetMapping(path = "{queryText}")
    public FindInstrumentsDTO showInstrument(@PathVariable String queryText) {
        return instrumentsService.showFindInstrument(queryText);
    }

}
