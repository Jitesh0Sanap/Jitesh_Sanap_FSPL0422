package com.sampleproject.EmployeeManagementSystem.services;

import com.sampleproject.EmployeeManagementSystem.dto.EmployeeDto;
import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import com.sampleproject.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employeeinfo addData(EmployeeDto employeeDto){
        Employeeinfo employeeinfo = new Employeeinfo();
        employeeinfo.setEmpId(0L);
        employeeinfo.setEmpFirstName(employeeDto.getEmpFirstName());
        employeeinfo.setEmpLastName(employeeDto.getEmpLastName());
        employeeinfo.setEmpEmail(employeeDto.getEmpEmail());
        employeeinfo.setEmpDesignation(employeeDto.getEmpDesignation());
        employeeinfo.setEmpDept(employeeDto.getEmpDept());
        employeeinfo.setEmpDateOfJoining(employeeDto.getEmpDateOfJoining());
        employeeinfo.setEmpSalary(employeeDto.getEmpSalary());
        employeeinfo.setEmpAge(employeeDto.getEmpAge());
        employeeinfo.setEmpAddress(employeeDto.getEmpAddress());
        employeeinfo.setActive(true);
        employeeinfo.setCreatedBy(employeeDto.getCreatedBy());
        employeeinfo.setCreatedDate(LocalDateTime.now());
        employeeinfo.setUpdatedBy(employeeDto.getUpdatedBy());
        employeeinfo.setUpdatedDate(LocalDateTime.now());

        return employeeRepository.save(employeeinfo);
    }
}
