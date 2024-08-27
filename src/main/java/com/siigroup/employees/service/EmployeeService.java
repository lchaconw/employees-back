package com.siigroup.employees.service;

import com.siigroup.employees.models.Employee;
import com.siigroup.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        try {
            List<Employee> employees = employeeRepository.getAll();
            for (Employee employee : employees) {
                double annualSalary = calculateAnnualSalary(employee);
                employee.setAnnualSalary(annualSalary);
            }
            return employees;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching employees", e);
        }
    }

    public Employee getEmployeeById(int id) {
        try {
            Employee employee = employeeRepository.getById(id);
            if (employee == null) {
                throw new RuntimeException("Employee with id: " + id + " not found");
            }
            double annualSalary = calculateAnnualSalary(employee);
            employee.setAnnualSalary(annualSalary);
            return employee;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching employee with id: " + id, e);
        }
    }

    private double calculateAnnualSalary(Employee employee) {
        return employee.getEmployee_salary() * 12;
    }
}
