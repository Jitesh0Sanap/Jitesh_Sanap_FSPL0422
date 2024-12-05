package com.sampleproject.EmployeeManagementSystem.Exception;

import com.sampleproject.EmployeeManagementSystem.Payload.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponce> employeeNotFoundExceptionHandler(EmployeeNotFoundException ex){
        String message = ex.getMessage();
        return new ResponseEntity<ApiResponce>(new ApiResponce(message , false) , HttpStatus.NOT_FOUND);
    }
}
