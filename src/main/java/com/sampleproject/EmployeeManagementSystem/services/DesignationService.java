package com.sampleproject.EmployeeManagementSystem.services;

import com.sampleproject.EmployeeManagementSystem.Exception.EmployeeNotFoundException;
import com.sampleproject.EmployeeManagementSystem.dto.DesignationDto;
import com.sampleproject.EmployeeManagementSystem.entity.DesignationEntity;
import com.sampleproject.EmployeeManagementSystem.repository.DesignationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    public List<DesignationEntity> getAllData() {
        List<DesignationEntity> listAllDesignation = designationRepository.findAll();
        return listAllDesignation;
    }

    public DesignationEntity getDesignationById(long desigId) {
        DesignationEntity designationEntity = designationRepository.findById(desigId).orElseThrow(()-> new EmployeeNotFoundException("Designation", "desigId", desigId) );
        return designationEntity;
    }

    public DesignationEntity updateDesignation(DesignationDto designationDto, long desigId) {
        DesignationEntity designationEntity = designationRepository.findById(desigId).orElseThrow(() -> new EmployeeNotFoundException("Designation", "desigId", desigId));
        designationEntity.setDesignationName(designationDto.getDesignationName());
        designationEntity.setCreatedBy(designationDto.getCreatedBy());
        designationEntity.setUpdatedBy(designationDto.getUpdatedBy());
        return designationRepository.save(designationEntity);
    }

    public void deleteDesignation(long desigId) {
        DesignationEntity designationEntity = designationRepository.findById(desigId).orElseThrow(() -> new EmployeeNotFoundException("Designation", "desigId", desigId));
        designationRepository.delete(designationEntity);
    }


}
