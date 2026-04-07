package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.service.ParticipantsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/participants")
public class ParticipantsController {

    private final ParticipantsService participantsService;

    public ParticipantsController(ParticipantsService participantsService) {
        this.participantsService = participantsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getParticipants(@RequestParam String sport) {
        return participantsService.getParticipants(sport);
    }
}
