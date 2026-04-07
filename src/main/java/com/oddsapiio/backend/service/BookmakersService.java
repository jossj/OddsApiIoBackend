package com.oddsapiio.backend.service;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookmakersService {

    private final OddsApiClient client;

    public BookmakersService(OddsApiClient client) {
        this.client = client;
    }

    public String getBookmakers() {
        return client.getPublic("/bookmakers");
    }

    public String getSelectedBookmakers() {
        return client.get("/bookmakers/selected", null);
    }

    public String selectBookmakers(String bookmakers) {
        return client.get("/bookmakers/selected/select", Map.of("bookmakers", bookmakers));
    }
}
