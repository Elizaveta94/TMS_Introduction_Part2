package com.tms.cars.controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LogListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("New session create");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
