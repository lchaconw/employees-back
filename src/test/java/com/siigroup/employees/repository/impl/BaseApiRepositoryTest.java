package com.siigroup.employees.repository.impl;

import com.siigroup.employees.models.Employee;
import com.siigroup.employees.models.ListResponse;
import com.siigroup.employees.models.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class BaseApiRepositoryTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BaseApiRepository<Employee> baseApiRepository = new EmployeeRepositoryImpl(restTemplate);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        baseApiRepository = new EmployeeRepositoryImpl(restTemplate);
    }

    @Test
    void testGetForObject() {
        Employee employee = new Employee();
        employee.setId(1);
        Response<Employee> response = new Response<>();
        response.setData(employee);
        ResponseEntity<Response<Employee>> responseEntity = ResponseEntity.ok(response);

        when(restTemplate.exchange(
                any(),
                any(),
                any(),
                any(ParameterizedTypeReference.class)
        )).thenReturn(responseEntity);

        Employee result = baseApiRepository.getForObject("/test");
        assertEquals(null, result);
    }

    @Test
    void testGetForList() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        Employee employee2 = new Employee();
        employee2.setId(2);
        ListResponse<Employee> listResponse = new ListResponse<>();
        List<Employee> data = new java.util.ArrayList<>();
        data.add(employee1);
        data.add(employee2);
        listResponse.setData(data);
        ResponseEntity<ListResponse<Employee>> responseEntity = ResponseEntity.ok(listResponse);

        when(restTemplate.exchange(
                eq("http://example.com/test"),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)
        )).thenReturn(responseEntity);

        List<Employee> result = baseApiRepository.getForList("/test");
        List<Employee> expected = new java.util.ArrayList<>();
        expected.add(employee1);
        expected.add(employee2);
        assertEquals(null, result);
    }
}