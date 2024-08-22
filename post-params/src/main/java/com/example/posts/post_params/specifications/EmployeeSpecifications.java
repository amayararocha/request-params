package com.example.posts.post_params.specifications;

import com.example.posts.post_params.models.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class EmployeeSpecifications {

    public static Specification<Employee> hasFirstName(String firstName) {
        return (firstName == null || firstName.isEmpty()) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
    }

    public static Specification<Employee> isInDepartment(String department) {
        return (department == null || department.isEmpty()) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("department"), department);
    }

    public static Specification<Employee> hasMinSalary(Double minSalary) {
        return (minSalary == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary);
    }

    public static Specification<Employee> hiredAfter(LocalDate hiredAfter) {
        return (hiredAfter == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), hiredAfter);
    }

    public static Specification<Employee> hiredBefore(LocalDate hiredBefore) {
        return (hiredBefore == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), hiredBefore);
    }

    public static Specification<Employee> isActive(Boolean active) {
        return (active == null) ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("active"), active);
    }
}
