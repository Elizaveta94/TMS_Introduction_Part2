package com.tms.patterns.abstractFactory;

public class XmlParserFactory implements ParserFactory{
    @Override
    public Parser create() {
        return new XmlParser();
    }
}
