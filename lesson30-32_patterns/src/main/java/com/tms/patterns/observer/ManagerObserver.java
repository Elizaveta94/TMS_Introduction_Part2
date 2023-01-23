package com.tms.patterns.observer;

import java.util.List;

public class ManagerObserver {
    private final List<Observer> observers = List.of(new CountObserver(), new TextAnalyseObserver());

    public void notifyAll(String text) {
        observers.forEach(observer -> observer.notify(text));
    }
}
