package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.model.Sport;
import com.oddsapiio.backend.service.OddsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sports")
public class SportsController {

    private final OddsService oddsService;

    public SportsController(OddsService oddsService) {
        this.oddsService = oddsService;
    }

    @GetMapping
    public List<Sport> getAllSports() {
        return oddsService.getAllSports();
    }

    @GetMapping("/{sportKey}")
    public ResponseEntity<Sport> getSport(@PathVariable String sportKey) {
        return oddsService.getSportByKey(sportKey)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
