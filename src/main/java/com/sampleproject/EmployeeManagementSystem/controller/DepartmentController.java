package com.sampleproject.EmployeeManagementSystem.controller;

import com.sampleproject.EmployeeManagementSystem.dto.DepartmentDto;
import com.sampleproject.EmployeeManagementSystem.entity.DepartmentEntity;
import com.sampleproject.EmployeeManagementSystem.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/addData")
    public ResponseEntity<DepartmentEntity> addData(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentServices.addData(departmentDto) , CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<DepartmentEntity>> getAllData(){
        List<DepartmentEntity> getData = departmentServices.getAllData();
        return new ResponseEntity<>(getData , HttpStatus.FOUND);
    }
}
