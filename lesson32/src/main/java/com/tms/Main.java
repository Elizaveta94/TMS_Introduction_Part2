package com.tms;

import com.tms.service.RideManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms");
        RideManagerService rideManagerService = context.getBean(RideManagerService.class);
        rideManagerService.bet();
    }
}