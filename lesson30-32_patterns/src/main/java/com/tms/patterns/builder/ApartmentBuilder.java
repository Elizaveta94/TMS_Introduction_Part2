package com.tms.patterns.builder;

public interface ApartmentBuilder {
    ApartmentBuilder fixBathroom();

    ApartmentBuilder fixBedroom();

    ApartmentBuilder fixColor();

    ApartmentBuilder fixInterior();

    Apartment build();
}
