package com.sampleproject.EmployeeManagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDto {

    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empDesignation;
    private String empDept;
    private String empDateOfJoining;
    private double empSalary;
    private int empAge;
    private String empAddress;

    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime UpdatedDate;
}
