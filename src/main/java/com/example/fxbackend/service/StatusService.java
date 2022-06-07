package com.example.fxbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fxbackend.dto.ProjectDto;
import com.example.fxbackend.dto.StatusDto;
import com.example.fxbackend.dto.StatusModuleDto;
import com.example.fxbackend.entity.Status;
import com.example.fxbackend.repository.StatusRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusModuleDto getStatusModuleData(){
        List<Status> statusList = statusRepository.findAll();
        List<StatusDto> statusDtoList = statusList.stream()
                .map(StatusDto::of).collect(Collectors.toList());
        List<ProjectDto> projectDtoList = statusList.get(0).getProjects().stream()
                .map(ProjectDto::of).collect(Collectors.toList());
        StatusDto selectedStatusDto = StatusDto.of(statusList.get(0));
        StatusModuleDto statusModuleDto = new StatusModuleDto(selectedStatusDto, statusDtoList, projectDtoList);
        return statusModuleDto;
    }

    public StatusModuleDto getStatusModuleData(Long idStatus){
        List<Status> statusList = statusRepository.findAll();
        List<StatusDto> statusDtoList = statusList.stream()
                .map(StatusDto::of).collect(Collectors.toList());

        Optional<Status> optionalStatus = statusList.stream().filter(x -> idStatus.equals(x.getIdStatus())).findFirst();
        Status selectedStatus = optionalStatus.get();
        List<ProjectDto> projectDtoList = selectedStatus.getProjects().stream()
                .map(ProjectDto::of).collect(Collectors.toList());
        StatusModuleDto statusModuleDto = new StatusModuleDto(StatusDto.of(selectedStatus), statusDtoList, projectDtoList);
        return statusModuleDto;
    }


}
