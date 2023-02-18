package com.tms.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Random;

@Component("rider")
@Scope("prototype")
public class Rider {
    private int level;

    public Rider() {
        this.level = new Random().nextInt(1, 10);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rider rider = (Rider) o;
        return level == rider.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }

    @Override
    public String toString() {
        return "Rider{" +
                "level=" + level +
                '}';
    }
}
