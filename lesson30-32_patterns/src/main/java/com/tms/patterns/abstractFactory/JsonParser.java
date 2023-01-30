package com.tms.patterns.abstractFactory;

public class JsonParser implements Parser{
    @Override
    public void parse(String str) {
        System.out.println("I am Json Parser, parsing: " + str);
    }
}
