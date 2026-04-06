package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.model.OddsEvent;
import com.oddsapiio.backend.service.OddsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/odds")
public class OddsController {

    private final OddsService oddsService;

    public OddsController(OddsService oddsService) {
        this.oddsService = oddsService;
    }

    @GetMapping
    public List<OddsEvent> getAllOdds(@RequestParam(required = false) String sport) {
        if (sport != null && !sport.isBlank()) {
            return oddsService.getOddsEventsBySport(sport);
        }
        return oddsService.getAllOddsEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OddsEvent> getOddsById(@PathVariable String id) {
        return oddsService.getOddsEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
