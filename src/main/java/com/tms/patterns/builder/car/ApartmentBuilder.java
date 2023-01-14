package com.tms.patterns.builder.car;

public interface ApartmentBuilder {
    ApartmentBuilder fixBathroom();

    ApartmentBuilder fixBedroom();

    ApartmentBuilder fixColor();

    ApartmentBuilder fixInterior();

    Apartment build();
}
