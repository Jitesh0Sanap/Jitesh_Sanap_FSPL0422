package com.sampleproject.EmployeeManagementSystem.controller;

import com.sampleproject.EmployeeManagementSystem.dto.EmployeeDto;
import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import com.sampleproject.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/ems")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addData")
    public ResponseEntity<Employeeinfo> addData(@RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<>(employeeService.addData(employeeDto) , CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Employeeinfo>> getAllData(){
        return new ResponseEntity<>(employeeService.getAllData() , HttpStatus.FOUND);
    }

    @GetMapping("/getById/{empId}")
    public ResponseEntity<Optional<Employeeinfo>> getEmployeeById(@PathVariable long empId){
        Optional<Employeeinfo> employeeById = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeById , HttpStatus.FOUND);
    }


}
