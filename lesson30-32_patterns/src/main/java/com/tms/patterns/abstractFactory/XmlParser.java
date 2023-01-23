package com.tms.patterns.abstractFactory;

public class XmlParser implements Parser{
    @Override
    public void parse(String str) {
        System.out.println("I am Xml Parser, parsing: " + str);
    }
}
