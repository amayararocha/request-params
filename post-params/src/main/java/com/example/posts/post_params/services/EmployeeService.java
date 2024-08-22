package com.example.posts.post_params.services;

import com.example.posts.post_params.models.Employee;
import com.example.posts.post_params.respositories.EmployeeRepository;
import com.example.posts.post_params.specifications.EmployeeSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(String firstName, String department,
                                       Double minSalary, LocalDate hiredAfter,
                                       LocalDate hiredBefore, Boolean active) {
        return employeeRepository.findAll(
                Specification.where(EmployeeSpecifications.hasFirstName(firstName))
                        .and(EmployeeSpecifications.isInDepartment(department))
                        .and(EmployeeSpecifications.hasMinSalary(minSalary))
                        .and(EmployeeSpecifications.hiredAfter(hiredAfter))
                        .and(EmployeeSpecifications.hiredBefore(hiredBefore))
                        .and(EmployeeSpecifications.isActive(active))
        );
    }
}
