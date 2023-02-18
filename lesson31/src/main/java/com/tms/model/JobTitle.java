package com.tms.model;

public enum JobTitle {
    DIRECTOR(2.1),
    WORKER(1.2);

    private double coefficient;

    JobTitle(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
