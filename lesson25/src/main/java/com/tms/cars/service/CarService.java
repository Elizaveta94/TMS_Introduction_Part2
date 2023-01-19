package com.tms.cars.service;

import com.tms.cars.bd.CarDBConnector;
import com.tms.cars.model.Car;

import java.util.List;

public class CarService {

    private final CarDBConnector dbConnector;

    public CarService(CarDBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public List<Car> getAllCars() {
        return dbConnector.getAllCars();
    }

    public Car getCar(long id) {
        return dbConnector.getCar(id);
    }

    public Car saveCar(Car car) {
        dbConnector.saveCar(car);
        return car;
    }

    public Car updateCar(Car car) {
        dbConnector.updateCar(car);
        return car;
    }

    public long deleteCar(long id) {
        dbConnector.deleteCar(id);
        return id;
    }
}




