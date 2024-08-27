package com.siigroup.employees.controller;

import com.siigroup.employees.models.Employee;
import com.siigroup.employees.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class EmployeesControllerTest {
    @InjectMocks
    private EmployeesController employeesController;
    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetEmployees() {
        List<Employee> employeeList = getEmployees();
        Mockito.when(employeeService.getEmployees()).thenReturn(employeeList);
        List<Employee> result = employeesController.getAllEmployees();
        Assertions.assertEquals(employeeList, result);
    }

    @Test
    public void testGetEmployeeById() {
        int id = 1;
        Employee employee = getEmployee();
        Mockito.when(employeeService.getEmployeeById(id)).thenReturn(employee);
        Employee result = employeesController.getEmployeeById(id);
        Assertions.assertEquals(employee, result);
    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(getEmployee());
        employeeList.add(getEmployee2());
        return employeeList;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployee_name("Tiger Nixon");
        employee.setEmployee_salary(320800);
        employee.setEmployee_age(61);
        employee.setProfile_image("test");
        return employee;
    }

    public Employee getEmployee2() {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setEmployee_name("Garrett Winters");
        employee.setEmployee_salary(170750);
        employee.setEmployee_age(63);
        employee.setProfile_image("test");
        return employee;
    }
}
