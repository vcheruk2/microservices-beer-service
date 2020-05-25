package com.ravi.microservicesbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.microservicesbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    String uuid = "3749e985-128d-4348-868a-1a1a1b44a54f";

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get(BeerController.BASE_URL + "/" + uuid)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // then
        //BDDMockito.then()
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                            .beerName("Test Beer")
                            .createdDate(OffsetDateTime.of(2020, 5, 25, 9, 25, 0, 0, ZoneOffset.UTC))
                            .price(BigDecimal.valueOf(10.7))
                            .quantityOnHand(1)
                            .build();

        String mappedJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post(BeerController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mappedJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {

        BeerDto beerDto = BeerDto.builder()
                .beerName("Test Beer")
                .createdDate(OffsetDateTime.of(2020, 5, 25, 9, 25, 0, 0, ZoneOffset.UTC))
                .price(BigDecimal.valueOf(10.7))
                .quantityOnHand(1)
                .build();

        String mappedJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put(BeerController.BASE_URL + "/" + uuid )
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mappedJson))
                .andExpect(status().isNoContent());
    }
}