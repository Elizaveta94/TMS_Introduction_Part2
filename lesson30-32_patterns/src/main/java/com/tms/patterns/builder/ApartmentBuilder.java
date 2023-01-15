package com.tms.patterns.builder;

public class ApartmentBuilder {
    private int bathroom;
    private int bedroom;
    private String color;
    private String interior;

    public ApartmentBuilder setBathroom(int bathroom) {
        this.bathroom = bathroom;
        return this;
    }

    public ApartmentBuilder setBedroom(int bedroom) {
        this.bedroom = bedroom;
        return this;
    }

    public ApartmentBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public ApartmentBuilder setInterior(String interior) {
        this.interior = interior;
        return this;
    }

    public Apartment build() {
        Apartment apartment = new Apartment(bathroom, bedroom, color, interior);
        if (apartment.doQualityCheck()) {
            return apartment;
        } else {
            System.out.println("Invalid parameters");
        }
        return null;
    }

}
