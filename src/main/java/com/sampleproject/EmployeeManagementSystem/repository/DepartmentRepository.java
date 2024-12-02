package com.sampleproject.EmployeeManagementSystem.repository;

import com.sampleproject.EmployeeManagementSystem.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Long> {
}
