package com.tms.service;

import com.tms.model.CourseEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    private final SessionFactory sessionFactory;

    public void save(CourseEntity courseEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(courseEntity);
        transaction.commit();
        session.close();
    }

    public CourseEntity get(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CourseEntity courseEntity = session.find(CourseEntity.class, id);
        transaction.commit();
        session.close();
        return courseEntity;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CourseEntity courseEntity = session.find(CourseEntity.class, id);
        session.delete(courseEntity);
        transaction.commit();
        session.close();
    }
}
