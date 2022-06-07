package com.example.fxbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
    private List<Project> projects;

}
