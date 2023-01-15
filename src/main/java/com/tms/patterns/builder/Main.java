package com.tms.patterns.builder;

public class Main {
    public static void main(String[] args) {
        ApartmentBuilder builder = new ModernApartmentBuilder();
        Director engineer = new Director(builder);
        Apartment apartment = (engineer.manufactureApartment());
        if (apartment != null) {
            System.out.println("The apartment below is booked: ");
            System.out.println(apartment);
        }
    }
}
