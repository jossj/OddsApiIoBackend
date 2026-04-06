package com.oddsapiio.backend.model;

import java.util.List;

public class Market {

    private String key;
    private String lastUpdate;
    private List<Outcome> outcomes;

    public Market() {}

    public Market(String key, String lastUpdate, List<Outcome> outcomes) {
        this.key = key;
        this.lastUpdate = lastUpdate;
        this.outcomes = outcomes;
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    public List<Outcome> getOutcomes() { return outcomes; }
    public void setOutcomes(List<Outcome> outcomes) { this.outcomes = outcomes; }
}
