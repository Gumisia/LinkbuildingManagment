package com.example.fxbackend.dto;

import com.example.fxbackend.entity.Employee;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long idEmployee;
    private String firstname;
    private String lastname;
    private String birthDate;
    private String salary;

    public static EmployeeDto of(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setIdEmployee(employee.getIdEmployee());
        dto.setFirstname(employee.getFirstname());
        dto.setLastname(employee.getLastname());
        dto.setBirthDate(employee.getBirthDate());
        dto.setSalary(employee.getSalary());
        return dto;
    }
}
