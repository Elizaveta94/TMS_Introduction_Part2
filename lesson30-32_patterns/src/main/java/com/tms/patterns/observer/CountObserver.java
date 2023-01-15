package com.tms.patterns.observer;

public class CountObserver implements Observer {
    int count;

    @Override
    public void notify(String text) {
        count++;
        System.out.println("Count of speaks " + count);
    }
}
