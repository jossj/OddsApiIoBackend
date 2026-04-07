package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.service.EventsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventsController {

    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping(value = "/v1/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEvents(@RequestParam String sport,
                            @RequestParam(required = false) String league,
                            @RequestParam(required = false) String status) {
        return eventsService.getEvents(sport, league, status);
    }

    @GetMapping(value = "/v1/events/live", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLiveEvents(@RequestParam(required = false) String sport) {
        return eventsService.getLiveEvents(sport);
    }

    @GetMapping(value = "/v1/events/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchEvents(@RequestParam String query) {
        return eventsService.searchEvents(query);
    }

    @GetMapping(value = "/v1/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEventById(@PathVariable String id) {
        return eventsService.getEventById(id);
    }

    @GetMapping(value = "/v1/leagues", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLeagues(@RequestParam String sport) {
        return eventsService.getLeagues(sport);
    }
}
