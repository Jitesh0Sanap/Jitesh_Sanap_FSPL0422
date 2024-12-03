package com.sampleproject.EmployeeManagementSystem.services;

import com.sampleproject.EmployeeManagementSystem.dto.EmployeeDto;
import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import com.sampleproject.EmployeeManagementSystem.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Employeeinfo addData(EmployeeDto employeeDto){
//        Employeeinfo employeeinfo = new Employeeinfo();
//        employeeinfo.setEmpId(0L);
//        employeeinfo.setEmpFirstName(employeeDto.getEmpFirstName());
//        employeeinfo.setEmpLastName(employeeDto.getEmpLastName());
//        employeeinfo.setEmpEmail(employeeDto.getEmpEmail());
//        employeeinfo.setEmpDesignation(employeeDto.getEmpDesignation());
//        employeeinfo.setEmpDept(employeeDto.getEmpDept());
//        employeeinfo.setEmpDateOfJoining(employeeDto.getEmpDateOfJoining());
//        employeeinfo.setEmpSalary(employeeDto.getEmpSalary());
//        employeeinfo.setEmpAge(employeeDto.getEmpAge());
//        employeeinfo.setEmpAddress(employeeDto.getEmpAddress());
//        employeeinfo.setActive(true);
//        employeeinfo.setCreatedBy(employeeDto.getCreatedBy());
//        employeeinfo.setCreatedDate(LocalDateTime.now());
//        employeeinfo.setUpdatedBy(employeeDto.getUpdatedBy());
//        employeeinfo.setUpdatedDate(LocalDateTime.now());
//        return employeeRepository.save(employeeinfo);

        Employeeinfo employeeinfo = this.dtoToEmployeeinfo(employeeDto) ;
        employeeinfo.setActive(true);
        employeeinfo.setCreatedDate(LocalDateTime.now());
        employeeinfo.setUpdatedDate(LocalDateTime.now());

        return employeeRepository.save(employeeinfo);
    }


    public List<Employeeinfo> getAllData() {
        List<Employeeinfo> listEmployeeinfo = employeeRepository.findAll();
        return  listEmployeeinfo;
    }


    public Employeeinfo dtoToEmployeeinfo( EmployeeDto employeeDto){
        Employeeinfo employeeinfo = this.modelMapper.map(employeeDto , Employeeinfo.class);
        return employeeinfo;
    }

    public EmployeeDto employeeInfoToDto(Employeeinfo employeeinfo){
        EmployeeDto employeeDto = this.modelMapper.map(employeeinfo , EmployeeDto.class);
        return employeeDto;
    }

    public Optional<Employeeinfo> getEmployeeById(long empId) {
        Optional<Employeeinfo> getEmployeeById = employeeRepository.findById(empId);
        return getEmployeeById;
    }
}
