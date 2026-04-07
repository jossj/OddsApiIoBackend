package com.oddsapiio.backend.client;

import com.oddsapiio.backend.config.OddsApiProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * Proxy client for the Odds API (https://api.odds-api.io/v3).
 * Automatically appends the configured API key to every authenticated request.
 * Returns raw JSON strings so callers can pass them through unchanged.
 */
@Component
public class OddsApiClient {

    private final RestClient restClient;
    private final OddsApiProperties props;

    public OddsApiClient(RestClient restClient, OddsApiProperties props) {
        this.restClient = restClient;
        this.props = props;
    }

    /** Fetch a path that requires no authentication (e.g. /sports, /bookmakers). */
    public String getPublic(String path) {
        return restClient.get()
                .uri(path)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
    }

    /**
     * Fetch an authenticated path, appending apiKey plus any extra query params.
     * @param path    e.g. "/events"
     * @param params  additional query params (may be null or empty)
     */
    public String get(String path, Map<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path)
                .queryParam("apiKey", props.getApiKey());

        if (params != null) {
            params.forEach((k, v) -> {
                if (v != null && !v.isBlank()) {
                    builder.queryParam(k, v);
                }
            });
        }

        String uri = builder.build().toUriString();

        try {
            return restClient.get()
                    .uri(uri)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(String.class);
        } catch (HttpClientErrorException e) {
            throw e;
        }
    }
}
