package com.oddsapiio.backend.controller;

import com.oddsapiio.backend.service.BookmakersService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookmakers")
public class BookmakersController {

    private final BookmakersService bookmakersService;

    public BookmakersController(BookmakersService bookmakersService) {
        this.bookmakersService = bookmakersService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBookmakers() {
        return bookmakersService.getBookmakers();
    }

    @GetMapping(value = "/selected", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSelectedBookmakers() {
        return bookmakersService.getSelectedBookmakers();
    }

    @PutMapping(value = "/selected", produces = MediaType.APPLICATION_JSON_VALUE)
    public String selectBookmakers(@RequestParam String bookmakers) {
        return bookmakersService.selectBookmakers(bookmakers);
    }
}
