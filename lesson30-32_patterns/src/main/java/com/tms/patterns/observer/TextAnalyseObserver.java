package com.tms.patterns.observer;

public class TextAnalyseObserver implements Observer {
    @Override
    public void notify(String text) {
        System.out.println("Count of words in speak: " + text.split(" ").length);
    }
}
