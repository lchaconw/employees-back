package com.siigroup.employees.models;

import lombok.Data;

import java.util.List;

@Data
public class ListResponse<Employee> {
    private String status;
    private List<Employee> data;
    private String message;
}