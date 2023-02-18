package com.tms.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("pair")
@Scope("prototype")
public class Pair {
    private Horse horse;
    private Rider rider;

    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(horse, pair.horse) && Objects.equals(rider, pair.rider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horse, rider);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "horse=" + horse +
                ", rider=" + rider +
                '}';
    }
}
