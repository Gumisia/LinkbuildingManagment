package com.example.fxbackend.entity;

import com.example.fxbackend.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String birthDate;

    @Column
    private String salary;

    @OneToOne(mappedBy = "employee")
    private Operator operator;

    public static Employee of(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setBirthDate(dto.getBirthDate());
        employee.setSalary(dto.getSalary());
        return employee;
    }


    public void updateEmployee(EmployeeDto dto) {
        this.setFirstname(dto.getFirstname());
        this.setLastname(dto.getLastname());
        this.setBirthDate(dto.getBirthDate());
        this.setSalary(dto.getSalary());
    }
}
