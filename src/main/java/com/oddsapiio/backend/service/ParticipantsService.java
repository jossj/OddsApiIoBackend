package com.oddsapiio.backend.service;

import com.oddsapiio.backend.client.OddsApiClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ParticipantsService {

    private final OddsApiClient client;

    public ParticipantsService(OddsApiClient client) {
        this.client = client;
    }

    public String getParticipants(String sport) {
        return client.get("/participants", Map.of("sport", sport));
    }
}
