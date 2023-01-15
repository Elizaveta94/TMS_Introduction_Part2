package com.tms.patterns.builder;

public class Apartment {

    private int bathroom;
    private int bedroom;
    private String color;
    private String interior;

    public Apartment() {

        super();
    }

    public Apartment(int bathroom, int bedroom, String color, String interior) {
        this();
        this.bathroom = bathroom;
        this.bedroom = bedroom;
        this.color = color;
        this.interior = interior;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;

    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public boolean doQualityCheck() {
        return (color != null && !color.trim().isEmpty()) && (interior != null && !interior.trim().isEmpty());
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Apartment [bathroom=").append(bathroom).append(", bedroom=").append(bedroom).append(", color=").append(color).append(", interior=").append(interior);
        return builder.toString();
    }

}
