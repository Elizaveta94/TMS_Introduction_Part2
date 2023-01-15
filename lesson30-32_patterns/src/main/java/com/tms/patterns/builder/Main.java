package com.tms.patterns.builder;

public class Main {
    public static void main(String[] args) {
        ApartmentBuilder builder = new ApartmentBuilder();
        Apartment apartment = builder.setBedroom(1)
                .setBathroom(2)
                .setColor("Gray")
                .setInterior("Modern")
                .build();
        System.out.println(apartment);

    }
}
