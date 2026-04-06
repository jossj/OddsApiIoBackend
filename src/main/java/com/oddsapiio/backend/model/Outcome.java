package com.oddsapiio.backend.model;

public class Outcome {

    private String name;
    private double price;
    private Double point;

    public Outcome() {}

    public Outcome(String name, double price, Double point) {
        this.name = name;
        this.price = price;
        this.point = point;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Double getPoint() { return point; }
    public void setPoint(Double point) { this.point = point; }
}
