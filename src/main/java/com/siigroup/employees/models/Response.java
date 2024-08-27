package com.siigroup.employees.models;

import lombok.Data;

@Data
public class Response<T> {
    private String status;
    private T data;
    private String message;
}