package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GET /v1/sports  — list all 34 supported sports (no auth required).
 */
@RestController
@RequestMapping("/v1/sports")
public class SportsController {

    private final OddsApiClient client;

    public SportsController(OddsApiClient client) {
        this.client = client;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSports() {
        return client.getPublic("/sports");
    }
}
