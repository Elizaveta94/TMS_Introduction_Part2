package com.tms.service;

import com.tms.model.TeacherEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TeacherService {
    private final SessionFactory sessionFactory;


    public void save(TeacherEntity teacherEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacherEntity);
        transaction.commit();
        session.close();
    }

    public TeacherEntity get(Long id) {
        Session session = sessionFactory.openSession();
        TeacherEntity teacherEntity = session.find(TeacherEntity.class, id);
        session.close();
        return teacherEntity;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TeacherEntity teacherEntity = session.find(TeacherEntity.class, id);
        session.delete(teacherEntity);
        transaction.commit();
        session.close();
    }
}
