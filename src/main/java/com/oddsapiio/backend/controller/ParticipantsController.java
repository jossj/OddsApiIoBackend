package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * GET /v1/participants?sport={slug} — list teams/participants for a sport.
 */
@RestController
@RequestMapping("/v1/participants")
public class ParticipantsController {

    private final OddsApiClient client;

    public ParticipantsController(OddsApiClient client) {
        this.client = client;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getParticipants(@RequestParam String sport) {
        return client.get("/participants", Map.of("sport", sport));
    }
}
