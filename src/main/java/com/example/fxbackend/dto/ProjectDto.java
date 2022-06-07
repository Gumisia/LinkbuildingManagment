package com.example.fxbackend.dto;

import com.example.fxbackend.entity.Project;
import lombok.Data;

@Data
public class ProjectDto {
    private Long idProject;
    private String nameProject;
    private Double price;
    private String isPaid;
    private int executionTime;
    private int numberOfLinks;
    private String projectType;
    private Double budget;

    public static ProjectDto of(Project project){
        ProjectDto dto = new ProjectDto();
        dto.setIdProject(project.getIdProject());
        dto.setNameProject(project.getAddressURL());
        dto.setPrice(project.getPrice());
        dto.setExecutionTime(project.getExecutionTime());
        dto.setNumberOfLinks(project.getNumberOfLinks());
        dto.setProjectType(project.getProjectType().getName());
        dto.setBudget(project.getBudget());
        return dto;
    }

}
