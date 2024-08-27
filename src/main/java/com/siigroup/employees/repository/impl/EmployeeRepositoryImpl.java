package com.siigroup.employees.repository.impl;

import com.siigroup.employees.models.Employee;
import com.siigroup.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends BaseApiRepository<Employee> implements EmployeeRepository {
    public EmployeeRepositoryImpl(RestTemplate restTemplate) {
        super(restTemplate, "https://dummy.restapiexample.com/api/v1/");
    }

    @Override
    public List<Employee> getAll() {
        return getForList("employees");
    }

    @Override
    public Employee getById(int id) {
        return getForObject("employee/" + id);
    }
}
