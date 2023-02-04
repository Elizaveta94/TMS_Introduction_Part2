package com.tms.model;

import java.util.Objects;
import java.util.Random;

public class Horse {
    private int speed;

    public Horse() {
        this.speed = new Random().nextInt(20,80);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return speed == horse.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "speed=" + speed +
                '}';
    }
}
