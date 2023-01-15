package com.tms.patterns.builder;

public class Director {
    private ApartmentBuilder builder;

    public Director(ApartmentBuilder builder) {
        super();
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("Exception");
        }
    }

    public Apartment manufactureApartment() {
        return builder.fixBathroom().fixBedroom().fixColor().fixInterior().build();
    }
}
