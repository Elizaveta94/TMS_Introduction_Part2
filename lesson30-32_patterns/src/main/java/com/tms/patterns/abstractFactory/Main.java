package com.tms.patterns.abstractFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        FactoryProvider provider = new FactoryProvider();
        ParserFactory parserFactory = provider.getFactory(type);
        Parser parser = parserFactory.create();
        parser.parse("my file");
    }
}
