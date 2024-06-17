package ru.io6.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.io6.demo.dto.marketData.candles.RequestCandlesDTO;
import ru.io6.demo.dto.marketData.lastPrice.RequestGetLastPricesDTO;
import ru.io6.demo.dto.marketData.orderBook.RequestOrderBookDTO;

import java.math.BigDecimal;
import java.util.ArrayList;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class MarketDataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @Test
    public void testShowLastPrices() throws Exception {
        RequestGetLastPricesDTO dto = new RequestGetLastPricesDTO();
        dto.setInstrumentIds(new ArrayList<>());
        dto.getInstrumentIds().add("8e2b0325-0292-4654-8a18-4f63ed3b0e09");

        MockHttpServletRequestBuilder request = post("/api/marketData/getLastPrices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto));

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();

        assertThatJson(body).and(
                v -> v.node("lastPrices.[0].instrumentUid").isEqualTo("8e2b0325-0292-4654-8a18-4f63ed3b0e09")
        );
    }

    @Test
    public void testShowCandles() throws Exception {
        RequestCandlesDTO dto = new RequestCandlesDTO();
        dto.setFrom("2024-06-01T00:00:01.000Z");
        dto.setTo("2024-06-14T00:00:01.000Z");
        dto.setInstrumentId("962e2a95-02a9-4171-abd7-aa198dbe643a");

        MockHttpServletRequestBuilder request = post("/api/marketData/getCandles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto));

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(
                v -> v.node("candles.[8].open.units").asNumber().isBetween(new BigDecimal(90), new BigDecimal(160))
        );
    }

    @Test
    public void testShowOrderBook() throws Exception {
        RequestOrderBookDTO dto = new RequestOrderBookDTO();
        dto.setInstrumentId("962e2a95-02a9-4171-abd7-aa198dbe643a");

        MockHttpServletRequestBuilder request = post("/api/marketData/getOrderBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto));

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(
                v -> v.node("instrumentUid").isEqualTo("962e2a95-02a9-4171-abd7-aa198dbe643a")
        );

        assertThatJson(body).and(
                v -> v.node("bids").isArray().hasSize(50)
        ).and(
                v -> v.node("asks").isArray().hasSize(50)
        );
    }

    @Test
    public void testShowTradingStatus() throws Exception {
        MockHttpServletRequestBuilder request
                = get("/api/marketData/getTradingStatus/962e2a95-02a9-4171-abd7-aa198dbe643a");
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(
                v -> v.node("instrumentUid").isEqualTo("962e2a95-02a9-4171-abd7-aa198dbe643a")
        );

        assertThatJson(body).and(
                v -> v.node("apiTradeAvailableFlag").isEqualTo(true)
        );
    }
}


