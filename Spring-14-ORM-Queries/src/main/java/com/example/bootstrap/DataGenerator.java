package com.example.bootstrap;

import com.example.entity.Region;
import com.example.repostirory.DepartmentRepository;
import com.example.repostirory.EmployeeRepository;
import com.example.repostirory.RegionsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionsRepository regionsRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionsRepository regionsRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionsRepository = regionsRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------------REGION START----------------------");
        System.out.println("findByCounty:"+regionsRepository.findByCountry("Canada"));

        System.out.println("--------------Distinct Region--------------");
        System.out.println("FindDistinctByCountry: "+regionsRepository.findDistinctByCountry("Canada"));

        System.out.println("--------------Containing--------------");
        System.out.println("findCountryContaining:"+regionsRepository.findByCountryContaining("United"));

        System.out.println("--------------Containing In Order--------------");
        System.out.println("findCountryContaining:"+regionsRepository.findByCountryContainingOrderByCountry("Asia"));

        System.out.println("--------------Top 2--------------");
        System.out.println("top2:"+regionsRepository.findTop2ByCountry("Asia"));

        System.out.println("-------------------------REGION END-------------------------");
        System.out.println();

        System.out.println("-------------------------DEPARTMENT START----------------------");

        System.out.println("findDistinctTop3ByDivisionContaining"+departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("-------------------------DEPARTMENT END----------------------");

        System.out.println("-------------------------EMPLOYEE START----------------------");

        System.out.println("findByEmail"+employeeRepository.findByEmail("thuddlestonrf@yahoo.co.jp"));
        System.out.println("-------------------------EMPLOYEE END----------------------");






    }
}
