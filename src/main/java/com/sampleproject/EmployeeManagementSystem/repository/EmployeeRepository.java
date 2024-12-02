package com.sampleproject.EmployeeManagementSystem.repository;

import com.sampleproject.EmployeeManagementSystem.entity.Employeeinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employeeinfo , Long> {


}
