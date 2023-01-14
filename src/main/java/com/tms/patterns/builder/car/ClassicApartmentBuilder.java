package com.tms.patterns.builder.car;

public class ClassicApartmentBuilder implements ApartmentBuilder {
    private int bathroom;
    private int bedroom;
    private String color;
    private String interior;

    public ClassicApartmentBuilder() {
        super();
    }

    @Override
    public ApartmentBuilder fixBathroom() {
        System.out.println("Classical one bathroom");
        this.bathroom = 1;
        return this;
    }

    @Override
    public ApartmentBuilder fixBedroom() {
        System.out.println("Classical one bedroom");
        this.bedroom = 1;
        return this;
    }



    @Override
    public ApartmentBuilder fixColor() {
        System.out.println("Сlassic apartment in pastel colors");
        this.color = "Gray color";
        return this;
    }

    @Override
    public ApartmentBuilder fixInterior() {
        System.out.println("Classic apartment in Minimalism interior");
        this.interior = "Minimalism";
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
