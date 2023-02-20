package com.tms.model;

import lombok.Data;

import java.util.Random;

@Data
public class Rider {
    private int level;
    private int number;
    private int win;

    public Rider(int number) {
        this.level = new Random().nextInt(1, 10);
        this.number = number;
        this.win = new Random().nextInt(0, 10);

    }
}
