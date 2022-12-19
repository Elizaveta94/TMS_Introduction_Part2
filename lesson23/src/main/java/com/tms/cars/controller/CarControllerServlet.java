package com.tms.cars.controller;

import com.tms.cars.model.Car;
import com.tms.cars.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CarControllerServlet extends HttpServlet {

    private CarService carService;

    @Override
    public void init() throws ServletException {
        super.init();
       carService = new CarService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Car car = new Car(brand, model, id);
        car = carService.saveCar(car);
        String res = car.toString();
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println(res);
        outputStream.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null) {
            List<Car> cars = carService.getAllCars();
            String res = Arrays.toString(cars.toArray());
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.println(res);
            outputStream.close();
        } else {
            long id = Long.valueOf(idParam);
            Car car = carService.getCar(id);
            String res = car.toString();
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.println(res);
            outputStream.close();

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Car car = new Car(brand, model, id);
        car = carService.updateCar(car);
        String res = car.toString();
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println(res);
        outputStream.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        carService.deleteCar(id);
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println(String.valueOf(id));
        outputStream.close();
    }
}