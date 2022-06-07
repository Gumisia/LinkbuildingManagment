package com.example.fxbackend.entity;

import com.example.fxbackend.dto.ProjectSaveDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProject;

    @Column
    private String addressURL;

    @Column
    private double price;

    @Column
    private boolean isPaid;

    @Column
    private int executionTime;

    @Column
    private int numberOfLinks;

    @Column
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idProjectType")
    private ProjectType projectType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idStatus")
    private Status status;

    /*

        //Company
        @Column
        private String NIP;
        @Column
        private String phoneNumber;
        @Column
        private String street;
        @Column
        private int number;
        @Column
        private String city;
    */
    //TrustRank
    @Column
    private double budget;

    public static Project of(ProjectSaveDto dto) {
        Project project = new Project();
        project.setAddressURL(dto.getAddressURL());
        project.setPrice(dto.getPrice());
        project.setPaid(Boolean.parseBoolean(String.valueOf(dto.isPaid())));
        project.setExecutionTime(dto.getExecutionTime());
        project.setNumberOfLinks(dto.getNumberOfLinks());
        project.setNotes(dto.getNotes());
        project.setBudget(dto.getBudget());
        return project;

    }
    //Advertisment - none attributes


}
