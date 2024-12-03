package com.sampleproject.EmployeeManagementSystem.services;

import com.sampleproject.EmployeeManagementSystem.dto.DesignationDto;
import com.sampleproject.EmployeeManagementSystem.entity.DesignationEntity;
import com.sampleproject.EmployeeManagementSystem.repository.DesignationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

//    @Autowired
//    private ModelMapper modelMapper;

    public DesignationEntity addData(DesignationDto designationDto) {

        DesignationEntity designationEntity = new DesignationEntity();
        designationEntity.setDesignationName(designationDto.getDesignationName());
        designationEntity.setActive(true);
        designationEntity.setCreatedBy(designationDto.getCreatedBy());
        designationEntity.setCreatedDate(LocalDateTime.now());
        designationEntity.setUpdatedBy(designationDto.getUpdatedBy());
        designationEntity.setUpdatedDate(LocalDateTime.now());

//        DesignationEntity designationEntity =modelMapper.map(designationDto , DesignationEntity.class);
//        designationEntity.setActive(true);
//        designationEntity.setCreatedDate(LocalDateTime.now());
//        designationEntity.setUpdatedDate(LocalDateTime.now());
        return designationRepository.save(designationEntity);
    }

    public List<DesignationEntity> getAllData(){
        List<DesignationEntity> listAllDesignation = designationRepository.findAll();
        return listAllDesignation;
    }
}
