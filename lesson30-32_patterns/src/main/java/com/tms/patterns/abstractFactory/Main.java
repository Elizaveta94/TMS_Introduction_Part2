package com.tms.patterns.abstractFactory;

public class Main {
    public static void main(String[] args) {
        FactoryProvider provider = new FactoryProvider();
        ParserFactory csvParserFactory = provider.getFactory("csv");
        Parser csvParser = csvParserFactory.create();
        csvParser.parse("csv file");
    }
}
