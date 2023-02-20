package com.tms.model;

import lombok.Data;

import java.util.Random;

@Data
public class Horse {
    private int speed;
    private int number;
    private int win;
    private int stamina;

    public Horse(int number) {
        this.speed = new Random().nextInt(20, 80);
        this.number = number;
        this.win = new Random().nextInt(0, 10);
        this.stamina = new Random().nextInt(6,10);
    }
}
