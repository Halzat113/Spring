package com.example.repostirory;

import com.example.entity.Department;
import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //Display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //Display all Departments in the health Division
    List<Department> findByDivisionIs(String division);
    //OR
    List<Department> findByDivisionEquals(String division);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> divisions);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);  //ectroc

}
