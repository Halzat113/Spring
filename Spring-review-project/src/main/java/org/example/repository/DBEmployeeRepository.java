package org.example.repository;

import org.example.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

    //Assume we are getting this data from the db
    public int getHourlyRate(){
        Employee employee = new Employee("Harold Finch","IT",65);
        return employee.getHourlyRate();
    }
}
