package com.tms.cars.controller;

import com.tms.cars.bd.CachedCarDBConnector;
import com.tms.cars.model.Car;
import com.tms.cars.service.CarService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class CarControllerServlet extends HttpServlet {

    private final CarService carService = new CarService(new CachedCarDBConnector());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("delete") != null) {
            doDelete(req, resp);
            return;
        }
        if (req.getParameter("id") == null) {
            throw new ServletException("Enter id");
        }
        long id = Long.valueOf(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Car car = new Car(brand, model, id);
        carService.saveCar(car);
        List<Car> cars = carService.getAllCars();
        req.setAttribute("cars", cars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            List<Car> cars = carService.getAllCars();
            req.setAttribute("cars", cars);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            String id = req.getParameter("id");
            Car car = carService.getCar(Long.parseLong(id));
            if (!carService.getAllCars().contains(car)) {
                resp.getOutputStream().println("<h1>Car not found!</h1>");
            } else {
                List<Car> cars = new ArrayList<>();
                cars.add(car);
                req.setAttribute("cars", cars);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            long id = Long.parseLong(req.getParameter("id"));
            carService.deleteCar(id);
        }
        List<Car> cars = carService.getAllCars();
        req.setAttribute("cars", cars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addCookie(new Cookie("time", LocalDateTime.now().toString()));
        super.service(req, resp);
    }

}
