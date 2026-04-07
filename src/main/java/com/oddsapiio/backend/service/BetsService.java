package com.oddsapiio.backend.service;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BetsService {

    private final OddsApiClient client;

    public BetsService(OddsApiClient client) {
        this.client = client;
    }

    public String getValueBets(String bookmaker, String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("bookmaker", bookmaker);
        params.put("sport", sport);
        return client.get("/value-bets", params);
    }

    public String getArbitrageBets(String bookmakers, String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("bookmakers", bookmakers);
        params.put("sport", sport);
        return client.get("/arbitrage-bets", params);
    }
}
