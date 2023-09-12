package org.example.service;

import lombok.AllArgsConstructor;
import org.example.repository.EmployeeRepository;
import org.example.repository.HoursRepository;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SalaryService {
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;
    public void calculateRegularSalary(){
        //HourlyRate * Regular Hours
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }
}
