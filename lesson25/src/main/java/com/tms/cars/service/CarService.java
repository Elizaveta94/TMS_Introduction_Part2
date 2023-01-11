package com.tms.cars.service;

import com.tms.cars.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private static CarService instance;

    private CarService() {
    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService();
        }
        return instance;
    }

    private final static List<Car> carsStorage = new ArrayList<>();

    static {
        carsStorage.add(new Car("Opel", "Astra G", 1L));
        carsStorage.add(new Car("Mercedes", "GLA 200", 2L));
        carsStorage.add(new Car("Audi", "A8", 3L));
        carsStorage.add(new Car("BMW", "X6", 4L));
        carsStorage.add(new Car("Opel", "Astra K", 5L));
        carsStorage.add(new Car("Mercedes", "GLA 200", 6L));
        carsStorage.add(new Car("Audi", "Q6", 7L));
        carsStorage.add(new Car("BMW", "X3", 8L));
        carsStorage.add(new Car("Opel", "Astra G", 9L));
        carsStorage.add(new Car("Mercedes", "GLA 200", 10L));
        carsStorage.add(new Car("Audi", "A8", 11L));
        carsStorage.add(new Car("BMW", "X6", 12L));
        carsStorage.add(new Car("Opel", "Corsa", 13L));
        carsStorage.add(new Car("Mercedes", "W 212", 14L));
        carsStorage.add(new Car("Audi", "Q6", 15L));
        carsStorage.add(new Car("BMW", "X5", 16L));
    }


    public List<Car> getAllCars() {
        return carsStorage;

    }

    public Car getCar(long id) {
        return carsStorage.stream().filter(car -> car.getId() == id).findFirst().get();
    }

    public Car saveCar(Car car) {
        carsStorage.add(car);
        return car;

    }

    public Car updateCar(Car car) {
        Car carToUpdate = getCar(car.getId());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        return carToUpdate;
    }

    public long deleteCar(long id) {
        Car carToDelete = getCar(id);
        carsStorage.remove(carToDelete);
        return id;

    }
}




