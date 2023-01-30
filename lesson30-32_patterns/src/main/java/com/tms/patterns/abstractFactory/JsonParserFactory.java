package com.tms.patterns.abstractFactory;

public class JsonParserFactory implements ParserFactory{
    @Override
    public Parser create() {
        return new JsonParser();
    }
}
