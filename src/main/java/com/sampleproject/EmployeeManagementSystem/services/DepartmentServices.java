package com.sampleproject.EmployeeManagementSystem.services;

import com.sampleproject.EmployeeManagementSystem.dto.DepartmentDto;
import com.sampleproject.EmployeeManagementSystem.entity.DepartmentEntity;
import com.sampleproject.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity addData(DepartmentDto departmentDto) {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentDto.getDepartmentName());
        departmentEntity.setActive(true);
        departmentEntity.setCreatedBy(departmentDto.getCreatedBy());
        departmentEntity.setCreatedDate(LocalDateTime.now());
        departmentEntity.setUpdatedBy(departmentDto.getUpdatedBy());
        departmentEntity.setUpdatedDate(LocalDateTime.now());

        return departmentRepository.save(departmentEntity);
    }

    public List<DepartmentEntity> getAllData() {
        List<DepartmentEntity> listAllDepartment = departmentRepository.findAll();
        return listAllDepartment;
    }
}
