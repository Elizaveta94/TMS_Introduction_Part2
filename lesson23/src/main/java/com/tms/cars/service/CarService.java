package com.tms.cars.service;
import com.tms.cars.model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final static List<Car> carsStorage = new ArrayList<>();

    static {
        carsStorage.add(new Car("Opel", "Astra G", 1L));
        carsStorage.add(new Car("Mercedes", "GLA 200", 2L));
        carsStorage.add(new Car("Audi", "A8", 3L));
        carsStorage.add(new Car("BMW", "X6", 4L));
    }


    public List<Car> getAllCars() {
        return carsStorage;

    }

    public Car getCar(long id) {
        return  carsStorage.stream().filter(car -> car.getId() == id).findFirst().get();
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




