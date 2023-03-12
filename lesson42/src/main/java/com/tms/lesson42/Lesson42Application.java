package com.tms.lesson42;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson42Application implements CommandLineRunner {
    @Autowired
    private AppStartCounter appStartCounter;

    public static void main(String[] args) {
        SpringApplication.run(Lesson42Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        appStartCounter.increaseCount();
    }
}
