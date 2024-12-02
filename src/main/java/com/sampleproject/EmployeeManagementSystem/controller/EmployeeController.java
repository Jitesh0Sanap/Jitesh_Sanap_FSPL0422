package com.sampleproject.EmployeeManagementSystem.controller;

import com.sampleproject.EmployeeManagementSystem.dto.EmployeeDto;
import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import com.sampleproject.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/ems")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addData")
    public ResponseEntity<Employeeinfo> addData(@RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<>(employeeService.addData(employeeDto) , CREATED);
    }
}
