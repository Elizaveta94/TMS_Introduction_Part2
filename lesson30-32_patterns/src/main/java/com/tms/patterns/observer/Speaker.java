package com.tms.patterns.observer;

public class Speaker {
    private static final ManagerObserver managerObserver = new ManagerObserver();
    public void speak(String text) {
        managerObserver.notifyAll(text);
        System.out.println(text);
    }
}
