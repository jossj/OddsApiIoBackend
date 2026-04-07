package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Betting opportunity endpoints:
 *   GET /v1/value-bets       — positive EV opportunities (?bookmaker=name)
 *   GET /v1/arbitrage-bets   — arbitrage opportunities (?bookmakers=list)
 */
@RestController
public class BetsController {

    private final OddsApiClient client;

    public BetsController(OddsApiClient client) {
        this.client = client;
    }

    @GetMapping(value = "/v1/value-bets", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getValueBets(@RequestParam(required = false) String bookmaker,
                               @RequestParam(required = false) String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("bookmaker", bookmaker);
        params.put("sport", sport);
        return client.get("/value-bets", params);
    }

    @GetMapping(value = "/v1/arbitrage-bets", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getArbitrageBets(@RequestParam(required = false) String bookmakers,
                                   @RequestParam(required = false) String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("bookmakers", bookmakers);
        params.put("sport", sport);
        return client.get("/arbitrage-bets", params);
    }
}
