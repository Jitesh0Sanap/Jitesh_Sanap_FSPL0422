package com.sampleproject.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="Employee Details")
@Data
public class Employeeinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empDesignation;
    private String empDept;
    private String empDateOfJoining;
    private double empSalary;
    private int empAge;
    private String empAddress;

//    hoo columns
    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime UpdatedDate;


}

//2. Database Design

//
//        Employee Table:
//        Primary Key: employee_id.
//        Fields: name, email, phone, department_id, etc.

//        Department Table:
//        Primary Key: department_id.
//        Fields: department_name, description.

//        Leave Table
//        Fields: leaveid, employeeId, start_date, end_date, status.

//        project table
//        field : pName , noOfMember , managerName , tool

//        Relationships:
//        Many-to-One : many employee can have a one project.
//        One-to-Many : One Dept can have project
//        One-to-Many: One department can have many employees.
//        Many-to-One: Many employees can belong to one department.


//email dataof joining  emp id empfisrst , last , salary , age ,

//dept = deptis deptname
//
//degina degiid and name