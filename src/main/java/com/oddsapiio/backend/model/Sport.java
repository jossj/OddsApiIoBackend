package com.oddsapiio.backend.model;

public class Sport {

    private String key;
    private String group;
    private String title;
    private String description;
    private boolean active;

    public Sport() {}

    public Sport(String key, String group, String title, String description, boolean active) {
        this.key = key;
        this.group = group;
        this.title = title;
        this.description = description;
        this.active = active;
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
