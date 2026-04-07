package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.service.SportsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sports")
public class SportsController {

    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSports() {
        return sportsService.getSports();
    }
}
