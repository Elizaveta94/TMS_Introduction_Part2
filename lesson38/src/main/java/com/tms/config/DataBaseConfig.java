package com.tms.config;

import com.tms.model.CourseEntity;
import com.tms.model.TeacherEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class DataBaseConfig {
    @Bean
    SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:49153/teacher");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgrespw");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        properties.put(Environment.SHOW_SQL, "false");
        configuration.addProperties(properties);

        configuration.addAnnotatedClass(TeacherEntity.class);
        configuration.addAnnotatedClass(CourseEntity.class);

        return configuration.buildSessionFactory();
    }
}