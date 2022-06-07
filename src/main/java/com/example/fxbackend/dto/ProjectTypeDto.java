package com.example.fxbackend.dto;

import com.example.fxbackend.entity.ProjectType;
import lombok.Data;

@Data
public class ProjectTypeDto {

    private Long idQuantityType;
    private String name;

    public static ProjectTypeDto of(ProjectType projectType){
        ProjectTypeDto dto = new ProjectTypeDto();
        dto.setName(projectType.getName());
        dto.setIdQuantityType(projectType.getIdProjectType());
        return dto;
    }

}

