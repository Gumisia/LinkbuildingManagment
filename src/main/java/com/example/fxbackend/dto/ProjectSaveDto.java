package com.example.fxbackend.dto;

import lombok.Data;

@Data
public class ProjectSaveDto {
    private String addressURL;
    private Double price;
    private boolean isPaid;
    private int executionTime;
    private int numberOfLinks;
    private String notes;
    private Double budget;
    private Long idProjectType;
    private Long idStatus;


}
