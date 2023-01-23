package com.tms.patterns.abstractFactory;

public class FactoryProvider {
    public ParserFactory getFactory(String type) {
        return switch (type) {
            case ("xml") -> new XmlParserFactory();
            case ("csv") -> new CsvParserFactory();
            case ("json") -> new JsonParserFactory();
            default -> throw new RuntimeException("Can't create factory with type " + type);
        };
    }
}
