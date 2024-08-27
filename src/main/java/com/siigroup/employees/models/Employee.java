package com.siigroup.employees.models;

import lombok.Data;

@Data
public class Employee extends Person {
    private double employee_salary;
    private double annualSalary;
    private String profile_image;
}
