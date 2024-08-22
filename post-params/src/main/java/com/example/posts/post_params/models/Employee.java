package com.example.posts.post_params.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String position;
    private Double salary;
    private LocalDate hireDate;
    private String department;
    private Boolean active;
}
