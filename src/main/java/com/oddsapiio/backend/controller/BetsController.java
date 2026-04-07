package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.service.BetsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BetsController {

    private final BetsService betsService;

    public BetsController(BetsService betsService) {
        this.betsService = betsService;
    }

    @GetMapping(value = "/v1/value-bets", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getValueBets(@RequestParam(required = false) String bookmaker,
                               @RequestParam(required = false) String sport) {
        return betsService.getValueBets(bookmaker, sport);
    }

    @GetMapping(value = "/v1/arbitrage-bets", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getArbitrageBets(@RequestParam(required = false) String bookmakers,
                                   @RequestParam(required = false) String sport) {
        return betsService.getArbitrageBets(bookmakers, sport);
    }
}
