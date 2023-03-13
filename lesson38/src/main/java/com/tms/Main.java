package com.tms;

import com.tms.model.Address;
import com.tms.model.CourseEntity;
import com.tms.model.StudentEntity;
import com.tms.model.TeacherEntity;
import com.tms.service.CourseService;
import com.tms.service.StudentService;
import com.tms.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms");
        TeacherService teacherService = context.getBean(TeacherService.class);
        CourseService courseService = context.getBean(CourseService.class);
        StudentService studentService = context.getBean(StudentService.class);

        TeacherEntity teacherEntity1 = createTeacherEntity("Pavel");

        CourseEntity courseEntity1 = createCourseEntity("Java");

        CourseEntity courseEntity2 = createCourseEntity("Python");

        CourseEntity courseEntity3 = createCourseEntity("C++");

        StudentEntity studentEntity1 = createStudentEntity("Petr");
        StudentEntity studentEntity2 = createStudentEntity("Ivan");
        StudentEntity studentEntity3 = createStudentEntity("Anna");
        StudentEntity studentEntity4 = createStudentEntity("Alla");
        StudentEntity studentEntity5 = createStudentEntity("Liza");

        teacherEntity1.setCourses(List.of(courseEntity1, courseEntity2, courseEntity3));

        courseEntity1.setStudents(List.of(studentEntity1, studentEntity3));
        courseEntity2.setStudents(List.of(studentEntity1, studentEntity4, studentEntity5));
        courseEntity3.setStudents(List.of(studentEntity2, studentEntity4));

        teacherService.save(teacherEntity1);

        System.out.println("-----------------------------------");
        System.out.println(teacherService.get(teacherEntity1.getId()));
        CourseEntity coursePython = courseService.get(courseEntity2.getId());
        CourseEntity courseJava = courseService.get(courseEntity1.getId());
        studentService.unsubscribeFromCourse(studentEntity5,coursePython);
        studentService.subscribeToCourse(studentEntity5,courseJava);
        System.out.println(teacherService.get(teacherEntity1.getId()));
    }

    public static TeacherEntity createTeacherEntity(String name) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName(name);
        teacherEntity.setRemote(new Random().nextBoolean());
        teacherEntity.setStartDate(new Date());
        teacherEntity.setAddress(Address.builder().city("Gomel").street("Portovaia").build());
        return teacherEntity;
    }

    public static CourseEntity createCourseEntity(String name) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(name);
        return courseEntity;
    }

    public static StudentEntity createStudentEntity(String name) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        return studentEntity;
    }

}
