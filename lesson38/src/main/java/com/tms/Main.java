package com.tms;

import com.tms.model.Address;
import com.tms.model.CourseEntity;
import com.tms.model.TeacherEntity;
import com.tms.service.CourseService;
import com.tms.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms");
        TeacherService teacherService = context.getBean(TeacherService.class);
        CourseService courseService = context.getBean(CourseService.class);
        TeacherEntity teacherEntity1 = createTeacherEntity("Pavel");
        TeacherEntity teacherEntity2 = createTeacherEntity("Maria");
        TeacherEntity teacherEntity3 = createTeacherEntity("Alexandr");
        CourseEntity courseEntity1 = createCourseEntity("Java");
        CourseEntity courseEntity2 = createCourseEntity("Python");
        CourseEntity courseEntity3 = createCourseEntity("C++");
        teacherEntity2.setCourseEntity(courseEntity1);
        courseEntity3.setTeacherEntity(teacherEntity1);
        teacherService.save(teacherEntity1);
        teacherService.save(teacherEntity2);
        teacherService.save(teacherEntity3);
        courseService.save(courseEntity1);
        courseService.save(courseEntity2);
        courseService.save(courseEntity3);
        System.out.println("-----------------------------------");
        TeacherEntity teacherEntity = teacherService.get(2L);
        System.out.println(teacherEntity);
        CourseEntity courseEntity = courseService.get(3L);
        System.out.println(courseEntity);
        courseEntity = courseService.get(1L);
        System.out.println(courseEntity);
        teacherService.delete(2L);
        courseEntity = courseService.get(1L);
        System.out.println(courseEntity);
        teacherEntity = teacherService.get(2L);
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

}
