package com.tms;

import com.tms.model.Director;
import com.tms.model.JobTitle;
import com.tms.model.Worker;
import com.tms.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Petr","Petrov",5, JobTitle.WORKER);
        Worker worker2 = new Worker("Ivan","Ivanov",3,JobTitle.WORKER);
        Director director1 = new Director("Vasili","Vasiliev",10,JobTitle.DIRECTOR);
        worker1.print();
        worker2.print();
        director1.print();
        director1.addEmployee(worker1);
        director1.addEmployee(worker2);
        director1.print();
        Director director2 = new Director("Pavel","Pavlov",6,JobTitle.DIRECTOR);
        Worker worker3 = new Worker("Sergey","Sergeev",1,JobTitle.WORKER);
        director2.addEmployee(worker3);
        director1.addEmployee(director2);
        director1.print();
        System.out.println(EmployeeService.isDirectorHasEmployee(director1,"Pavel","Pavlov"));
    }
}