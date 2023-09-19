package org.example.service;

import lombok.AllArgsConstructor;
import org.example.repository.EmployeeRepository;
import org.example.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("RH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
        //HourlyRate * Regular Hours
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }
}
