package org.example;

import org.example.config.EmployeeConfig;
import org.example.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        SalaryService salaryService = container.getBean(SalaryService.class);

        salaryService.calculateRegularSalary();

    }
}