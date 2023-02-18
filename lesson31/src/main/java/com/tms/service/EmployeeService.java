package com.tms.service;

import com.tms.model.Director;
import com.tms.model.Employee;

import java.util.List;

public class EmployeeService {
    public static boolean isDirectorHasEmployee(Director director, String name, String surname) {
        List<Employee> employees = director.getEmployees();
        for (Employee e : employees) {
            if (e.getName().equals(name) && (e.getSurname().equals(surname))) {
                return true;
            } else if (e instanceof Director) {
                if (isDirectorHasEmployee((Director) e, name, surname)) {
                    return true;
                }
            }
        }
        return false;
    }
}
