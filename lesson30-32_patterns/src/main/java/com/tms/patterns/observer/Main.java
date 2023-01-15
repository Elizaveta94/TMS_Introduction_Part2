package com.tms.patterns.observer;

public class Main {
    public static void main(String[] args) {
        Speaker speaker1 = new Speaker();
        Speaker speaker2 = new Speaker();
        speaker1.speak("Hello, world!");
        speaker2.speak("Hello");
    }
}
