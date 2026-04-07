package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Bookmaker endpoints:
 *   GET  /v1/bookmakers              — list all bookmakers (no auth required)
 *   GET  /v1/bookmakers/selected     — get user's selected bookmakers
 *   PUT  /v1/bookmakers/selected     — select bookmakers (?bookmakers=list)
 */
@RestController
@RequestMapping("/v1/bookmakers")
public class BookmakersController {

    private final OddsApiClient client;

    public BookmakersController(OddsApiClient client) {
        this.client = client;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBookmakers() {
        return client.getPublic("/bookmakers");
    }

    @GetMapping(value = "/selected", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSelectedBookmakers() {
        return client.get("/bookmakers/selected", null);
    }

    @PutMapping(value = "/selected", produces = MediaType.APPLICATION_JSON_VALUE)
    public String selectBookmakers(@RequestParam String bookmakers) {
        return client.get("/bookmakers/selected/select", Map.of("bookmakers", bookmakers));
    }
}
