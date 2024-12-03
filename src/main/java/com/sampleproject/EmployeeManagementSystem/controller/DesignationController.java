package com.sampleproject.EmployeeManagementSystem.controller;

import com.sampleproject.EmployeeManagementSystem.dto.DesignationDto;
import com.sampleproject.EmployeeManagementSystem.dto.EmployeeDto;
import com.sampleproject.EmployeeManagementSystem.entity.DesignationEntity;
import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import com.sampleproject.EmployeeManagementSystem.services.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/designation")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("/addData")
    public ResponseEntity<DesignationEntity> addData(@RequestBody DesignationDto designationDto){

        return new ResponseEntity<>(designationService.addData(designationDto) , CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<DesignationEntity>> getAllData(){
        List<DesignationEntity> getData = designationService.getAllData();
        return new ResponseEntity<>(getData , HttpStatus.FOUND);
    }
}
