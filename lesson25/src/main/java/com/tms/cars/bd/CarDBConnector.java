package com.tms.cars.bd;

import com.tms.cars.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDBConnector {

    private final String url;
    private final String username;
    private final String password;

    public CarDBConnector() {
        url = "jdbc:postgresql://localhost:49153/car";
        username = "postgres";
        password = "postgreswd";
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM car";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cars.add(
                        new Car(resultSet.getString("brand"),
                                resultSet.getString("model"),
                                resultSet.getLong("id"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public Car getCar(long id) {
        Car car = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM car WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car = new Car(resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    public void saveCar(Car car) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO Car (id, brand, model) Values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCar(Car car) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE car SET brand = ?, model = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setLong(3, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCar(long id) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM car WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
