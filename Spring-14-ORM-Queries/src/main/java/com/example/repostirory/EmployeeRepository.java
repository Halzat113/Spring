package com.example.repostirory;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Display all employees with email address ' '
    List<Employee> findByEmail(String email);

    //Display all employees with fist name '' and last name ' ' ,also show all employees with an emil address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);

    //Display all employees that first name is not ' '
    List<Employee> findByFirstNameIsNot(String name);

    //Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartsWith(String lastName);

    //Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less and equal then ' '
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //Display all employees where salaries greater and equal to ''in order
    List<Employee> findBySalaryGreaterThanOrderBySalary(Integer salary);

    //Display top unique employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have emil address
    List<Employee> findByEmailIsNull();

    @Query("SELECT e from Employee e WHERE e.email= 'bmanueau0@dion.ne.jp'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'bmanueau0@dion.ne.jp'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);


}
