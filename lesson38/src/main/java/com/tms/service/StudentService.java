package com.tms.service;

import com.tms.model.CourseEntity;
import com.tms.model.StudentEntity;
import com.tms.model.TeacherEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final SessionFactory sessionFactory;

    public StudentEntity subscribeToCourse(StudentEntity studentEntity, CourseEntity courseEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        courseEntity.getStudents().add(studentEntity);
        session.saveOrUpdate(courseEntity);
        transaction.commit();
        session.close();
        return studentEntity;
    }

    public void unsubscribeFromCourse(StudentEntity studentEntity, CourseEntity courseEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        courseEntity.getStudents().remove(studentEntity);
        session.saveOrUpdate(courseEntity);
        transaction.commit();
        session.close();
    }
}
