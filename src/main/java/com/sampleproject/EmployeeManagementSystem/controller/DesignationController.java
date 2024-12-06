package com.sampleproject.EmployeeManagementSystem.controller;

import com.sampleproject.EmployeeManagementSystem.Payload.ApiResponce;
import com.sampleproject.EmployeeManagementSystem.dto.DesignationDto;
import com.sampleproject.EmployeeManagementSystem.dto.EmployeeDto;
import com.sampleproject.EmployeeManagementSystem.entity.DesignationEntity;
import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import com.sampleproject.EmployeeManagementSystem.services.DesignationService;
import jakarta.websocket.server.PathParam;
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
    public ResponseEntity<DesignationEntity> addData(@RequestBody DesignationDto designationDto) {
        return new ResponseEntity<>(designationService.addData(designationDto), CREATED);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<DesignationEntity>> getAllData() {
        List<DesignationEntity> getData = designationService.getAllData();
        return new ResponseEntity<>(getData, HttpStatus.FOUND);
    }
    @GetMapping("/getDataById/{desigId}")
    public ResponseEntity<DesignationEntity> getDesignationById(@PathVariable long desigId){
        DesignationEntity designationEntity = designationService.getDesignationById(desigId);
        return new ResponseEntity<>(designationEntity , HttpStatus.FOUND);
    }

    @PutMapping("/updateDesig/{desigId}")
    public ResponseEntity<DesignationEntity> updateDesignation(@RequestBody DesignationDto designationDto , @PathVariable long desigId){
        return new ResponseEntity<>(designationService.updateDesignation(designationDto , desigId) , HttpStatus.OK);
    }
    @DeleteMapping("/deleteDesig/{desigId}")
    public ResponseEntity<ApiResponce> deleteDesignation(@PathVariable long desigId){
        designationService.deleteDesignation(desigId);
        return new ResponseEntity<>(new ApiResponce("desig deleted successfully" , true) , HttpStatus.OK);
    }
}
