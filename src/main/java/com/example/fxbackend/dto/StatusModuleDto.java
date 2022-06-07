package com.example.fxbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusModuleDto {

    private StatusDto selectedWarehouse;
    private List<StatusDto> statusDtoList;
    private List<ProjectDto> projectDtoList;
}
