package com.tms.cars.bd;

import com.tms.cars.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CachedCarDBConnector extends CarDBConnector {
    private final static List<Car> cache = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = super.getAllCars();
        cache.clear();
        cache.addAll(cars);
        return cars;
    }

    @Override
    public Car getCar(long id) {
        Optional<Car> carOpt = cache.stream().filter(c -> c.getId() == id).findFirst();
        if (carOpt.isPresent()) {
            return carOpt.get();
        } else {
            Car car = super.getCar(id);
            if (car != null) {
                cache.add(car);
            }
            return car;
        }
    }

    @Override
    public void saveCar(Car car) {
        super.saveCar(car);
        cache.add(car);
    }

    @Override
    public void updateCar(Car car) {
        super.updateCar(car);
        Car carToUpdate = getCar(car.getId());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
    }

    @Override
    public void deleteCar(long id) {
        Optional<Car> carOpt = cache.stream().filter(c -> c.getId() == id).findFirst();
        carOpt.ifPresent(cache::remove);
        super.deleteCar(id);
    }
}
