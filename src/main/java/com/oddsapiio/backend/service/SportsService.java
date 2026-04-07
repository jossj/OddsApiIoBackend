package com.oddsapiio.backend.service;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.stereotype.Service;

@Service
public class SportsService {

    private final OddsApiClient client;

    public SportsService(OddsApiClient client) {
        this.client = client;
    }

    public String getSports() {
        return client.getPublic("/sports");
    }
}
