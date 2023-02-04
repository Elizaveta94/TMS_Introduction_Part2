package com.tms;

import com.tms.service.RideManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RideManagerService rideManagerService = (RideManagerService) context.getBean("rideManagerService");
        rideManagerService.bet();
    }
}