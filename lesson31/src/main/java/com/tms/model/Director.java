package com.tms.model;

import java.util.ArrayList;
import java.util.List;

public class Director extends Employee {
    private List<Employee> employees;

    public Director(String name, String surname, int experience, JobTitle jobTitle) {
        super(name, surname, experience, jobTitle);
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public double countSalary() {
        return super.countSalary() + 100 * employees.size();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Employees:");
        employees.forEach(Employee::print);
        System.out.println("end");
    }

}
