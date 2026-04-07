package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Odds endpoints:
 *   GET /v1/odds                — get odds for a single event (?eventId=id&bookmakers=list)
 *   GET /v1/odds/multi          — get odds for up to 10 events (?eventIds=ids&bookmakers=list)
 *   GET /v1/odds/updated        — recently updated odds (?since=timestamp&bookmaker=name&sport=name)
 *   GET /v1/odds/movements      — odds movement history (?eventId=id&bookmaker=name&market=name)
 */
@RestController
@RequestMapping("/v1/odds")
public class OddsController {

    private final OddsApiClient client;

    public OddsController(OddsApiClient client) {
        this.client = client;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOdds(@RequestParam String eventId,
                          @RequestParam(required = false) String bookmakers,
                          @RequestParam(required = false) String markets) {
        Map<String, String> params = new HashMap<>();
        params.put("eventId", eventId);
        params.put("bookmakers", bookmakers);
        params.put("markets", markets);
        return client.get("/odds", params);
    }

    @GetMapping(value = "/multi", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOddsMulti(@RequestParam String eventIds,
                               @RequestParam(required = false) String bookmakers,
                               @RequestParam(required = false) String markets) {
        Map<String, String> params = new HashMap<>();
        params.put("eventIds", eventIds);
        params.put("bookmakers", bookmakers);
        params.put("markets", markets);
        return client.get("/odds/multi", params);
    }

    @GetMapping(value = "/updated", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUpdatedOdds(@RequestParam(required = false) String since,
                                 @RequestParam(required = false) String bookmaker,
                                 @RequestParam(required = false) String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("since", since);
        params.put("bookmaker", bookmaker);
        params.put("sport", sport);
        return client.get("/odds/updated", params);
    }

    @GetMapping(value = "/movements", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOddsMovements(@RequestParam String eventId,
                                   @RequestParam String bookmaker,
                                   @RequestParam String market) {
        Map<String, String> params = new HashMap<>();
        params.put("eventId", eventId);
        params.put("bookmaker", bookmaker);
        params.put("market", market);
        return client.get("/odds/movements", params);
    }
}
