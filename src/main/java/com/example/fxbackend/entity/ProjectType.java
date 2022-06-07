package com.example.fxbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjectType;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectType")
    private List<Project> projectList;

}
