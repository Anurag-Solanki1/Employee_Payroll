package com.example.EmployeePayrollApp.Model;

import com.example.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be empty")
    private String name;

    @Min(value = 10000, message = "Salary should be greater than 10000")
    private double salary;

    @NotBlank(message = "Department should not be empty")
    private String department;

    public Employee() {}

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
        this.department = employeePayrollDTO.getDepartment();
    }
}