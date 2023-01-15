package com.tms.patterns.builder;

public class ModernApartmentBuilder implements ApartmentBuilder {
    private int bathroom;
    private int bedroom;
    private String color;
    private String interior;

    public ModernApartmentBuilder() {
        super();
    }

    @Override
    public ApartmentBuilder fixBathroom() {
        System.out.println("Two bathrooms");
        this.bathroom = 2;
        return this;
    }

    @Override
    public ApartmentBuilder fixBedroom() {
        System.out.println("Tree bedrooms");
        this.bedroom = 3;
        return this;
    }



    @Override
    public ApartmentBuilder fixColor() {
        System.out.println("Modern apartment in Pearl color");
        this.color = "Pearl color";
        return this;
    }

    @Override
    public ApartmentBuilder fixInterior() {
        System.out.println("Classic apartment in Modern interior");
        this.interior = "Modern";
        return this;
    }

    @Override
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
