package com.tms.patterns.abstractFactory;

public class CsvParserFactory implements ParserFactory{
    @Override
    public Parser create() {
        return new CsvParser();
    }
}
