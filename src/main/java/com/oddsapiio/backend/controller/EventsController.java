package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Event endpoints:
 *   GET /v1/events           — list events for a sport (?sport=slug)
 *   GET /v1/events/live      — currently live events
 *   GET /v1/events/search    — search events (?query=term)
 *   GET /v1/events/{id}      — get event by ID
 *   GET /v1/leagues          — list leagues for a sport (?sport=slug)
 */
@RestController
public class EventsController {

    private final OddsApiClient client;

    public EventsController(OddsApiClient client) {
        this.client = client;
    }

    @GetMapping(value = "/v1/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEvents(@RequestParam String sport,
                            @RequestParam(required = false) String league,
                            @RequestParam(required = false) String status) {
        Map<String, String> params = new HashMap<>();
        params.put("sport", sport);
        params.put("league", league);
        params.put("status", status);
        return client.get("/events", params);
    }

    @GetMapping(value = "/v1/events/live", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLiveEvents(@RequestParam(required = false) String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("sport", sport);
        return client.get("/events/live", params);
    }

    @GetMapping(value = "/v1/events/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchEvents(@RequestParam String query) {
        return client.get("/events/search", Map.of("query", query));
    }

    @GetMapping(value = "/v1/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEventById(@PathVariable String id) {
        return client.get("/events/" + id, null);
    }

    @GetMapping(value = "/v1/leagues", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLeagues(@RequestParam String sport) {
        return client.get("/leagues", Map.of("sport", sport));
    }
}
