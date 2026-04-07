package com.oddsapiio.backend.service;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventsService {

    private final OddsApiClient client;

    public EventsService(OddsApiClient client) {
        this.client = client;
    }

    public String getEvents(String sport, String league, String status) {
        Map<String, String> params = new HashMap<>();
        params.put("sport", sport);
        params.put("league", league);
        params.put("status", status);
        return client.get("/events", params);
    }

    public String getLiveEvents(String sport) {
        Map<String, String> params = new HashMap<>();
        params.put("sport", sport);
        return client.get("/events/live", params);
    }

    public String searchEvents(String query) {
        return client.get("/events/search", Map.of("query", query));
    }

    public String getEventById(String id) {
        return client.get("/events/" + id, null);
    }

    public String getLeagues(String sport) {
        return client.get("/leagues", Map.of("sport", sport));
    }
}
