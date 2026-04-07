package com.oddsapiio.backend.service;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OddsService {

    private final OddsApiClient client;

    public OddsService(OddsApiClient client) {
        this.client = client;
    }

    public String getOdds(String eventId, String bookmakers, String markets) {
        Map<String, String> params = new HashMap<>();
        params.put("eventId", eventId);
        params.put("bookmakers", bookmakers);
        params.put("markets", markets);
        return client.get("/odds", params);
    }

    public String getOddsMulti(String eventIds, String bookmakers, String markets) {
        Map<String, String> params = new HashMap<>();
        params.put("eventIds", eventIds);
        params.put("bookmakers", bookmakers);
        params.put("markets", markets);
        return client.get("/odds/multi", params);
    }

    public String getUpdatedOdds(String since, String bookmaker, String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("since", since);
        params.put("bookmaker", bookmaker);
        params.put("sport", sport);
        return client.get("/odds/updated", params);
    }

    public String getOddsMovements(String eventId, String bookmaker, String market) {
        Map<String, String> params = new HashMap<>();
        params.put("eventId", eventId);
        params.put("bookmaker", bookmaker);
        params.put("market", market);
        return client.get("/odds/movements", params);
    }
}
