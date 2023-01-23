package com.tms.patterns.abstractFactory;

public class CsvParser implements Parser {

    @Override
    public void parse(String str) {
        System.out.println("I am Csv Parser, parsing: " + str);
    }
}
