package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.service.OddsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/odds")
public class OddsController {

    private final OddsService oddsService;

    public OddsController(OddsService oddsService) {
        this.oddsService = oddsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOdds(@RequestParam String eventId,
                          @RequestParam(required = false) String bookmakers,
                          @RequestParam(required = false) String markets) {
        return oddsService.getOdds(eventId, bookmakers, markets);
    }

    @GetMapping(value = "/multi", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOddsMulti(@RequestParam String eventIds,
                               @RequestParam(required = false) String bookmakers,
                               @RequestParam(required = false) String markets) {
        return oddsService.getOddsMulti(eventIds, bookmakers, markets);
    }

    @GetMapping(value = "/updated", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUpdatedOdds(@RequestParam(required = false) String since,
                                 @RequestParam(required = false) String bookmaker,
                                 @RequestParam(required = false) String sport) {
        return oddsService.getUpdatedOdds(since, bookmaker, sport);
    }

    @GetMapping(value = "/movements", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOddsMovements(@RequestParam String eventId,
                                   @RequestParam String bookmaker,
                                   @RequestParam String market) {
        return oddsService.getOddsMovements(eventId, bookmaker, market);
    }
}
