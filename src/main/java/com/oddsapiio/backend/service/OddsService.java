package com.oddsapiio.backend.service;

import com.oddsapiio.backend.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OddsService {

    private final List<Sport> sports = new ArrayList<>();
    private final List<OddsEvent> oddsEvents = new ArrayList<>();

    public OddsService() {
        initSampleData();
    }

    private void initSampleData() {
        sports.add(new Sport("americanfootball_nfl", "American Football", "NFL", "US Football", true));
        sports.add(new Sport("basketball_nba", "Basketball", "NBA", "US Basketball", true));
        sports.add(new Sport("soccer_epl", "Soccer", "EPL", "English Premier League", true));

        oddsEvents.add(new OddsEvent(
            "event-001",
            "americanfootball_nfl",
            "NFL",
            "2025-01-20T18:00:00Z",
            "Kansas City Chiefs",
            "Buffalo Bills",
            List.of(
                new Bookmaker("draftkings", "DraftKings", "2025-01-20T12:00:00Z", List.of(
                    new Market("h2h", "2025-01-20T12:00:00Z", List.of(
                        new Outcome("Kansas City Chiefs", -150, null),
                        new Outcome("Buffalo Bills", +130, null)
                    ))
                )),
                new Bookmaker("fanduel", "FanDuel", "2025-01-20T12:00:00Z", List.of(
                    new Market("h2h", "2025-01-20T12:00:00Z", List.of(
                        new Outcome("Kansas City Chiefs", -145, null),
                        new Outcome("Buffalo Bills", +125, null)
                    ))
                ))
            )
        ));

        oddsEvents.add(new OddsEvent(
            "event-002",
            "basketball_nba",
            "NBA",
            "2025-01-21T00:00:00Z",
            "Los Angeles Lakers",
            "Golden State Warriors",
            List.of(
                new Bookmaker("draftkings", "DraftKings", "2025-01-20T20:00:00Z", List.of(
                    new Market("h2h", "2025-01-20T20:00:00Z", List.of(
                        new Outcome("Los Angeles Lakers", +110, null),
                        new Outcome("Golden State Warriors", -130, null)
                    )),
                    new Market("spreads", "2025-01-20T20:00:00Z", List.of(
                        new Outcome("Los Angeles Lakers", -110, 3.5),
                        new Outcome("Golden State Warriors", -110, -3.5)
                    ))
                ))
            )
        ));
    }

    public List<Sport> getAllSports() {
        return Collections.unmodifiableList(sports);
    }

    public Optional<Sport> getSportByKey(String key) {
        return sports.stream().filter(s -> s.getKey().equals(key)).findFirst();
    }

    public List<OddsEvent> getAllOddsEvents() {
        return Collections.unmodifiableList(oddsEvents);
    }

    public List<OddsEvent> getOddsEventsBySport(String sportKey) {
        return oddsEvents.stream()
                .filter(e -> e.getSportKey().equals(sportKey))
                .toList();
    }

    public Optional<OddsEvent> getOddsEventById(String id) {
        return oddsEvents.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
}
