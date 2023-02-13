package com.tms.model;

public abstract class Employee {
    private final static int BASE_RATE = 1000;

    protected String name;
    protected String surname;
    protected int experience;
    protected JobTitle jobTitle;

    public Employee(String name, String surname, int experience, JobTitle jobTitle) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double countSalary() {
        return BASE_RATE * jobTitle.getCoefficient() * experience;
    }

    public void print() {
        System.out.println(name + " " + surname + " salary: " + countSalary());
    }
}
