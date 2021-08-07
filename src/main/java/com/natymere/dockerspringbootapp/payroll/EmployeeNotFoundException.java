package com.natymere.dockerspringbootapp.payroll;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(Long id){
        super("Could not find employee " + id);
    }
}
