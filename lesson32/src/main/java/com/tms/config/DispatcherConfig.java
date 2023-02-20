package com.tms.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class DispatcherConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.scan("com.tms");

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(context));

        registration.setLoadOnStartup(1);

        registration.addMapping("/");

    }
}
