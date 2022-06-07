package com.example.fxbackend.dto;

import lombok.Data;
import com.example.fxbackend.entity.Status;

@Data
public class StatusDto {

    private Long idStatus;
    private String name;

    public static StatusDto of(Status status){
        StatusDto dto = new StatusDto();
        dto.setIdStatus(status.getIdStatus());
        dto.setName(status.getName());
        return dto;
    }

}
