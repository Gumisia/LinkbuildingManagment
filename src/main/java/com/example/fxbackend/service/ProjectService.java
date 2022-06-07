package com.example.fxbackend.service;

import com.example.fxbackend.dto.ProjectSaveDto;
import com.example.fxbackend.entity.Project;
import com.example.fxbackend.entity.ProjectType;
import com.example.fxbackend.entity.Status;
import com.example.fxbackend.repository.ProjectRepository;
import com.example.fxbackend.repository.ProjectTypeRepository;
import com.example.fxbackend.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final StatusRepository statusRepository;
    private final ProjectTypeRepository projectTypeRepository;

    public Project saveProject(ProjectSaveDto dto){
        Optional<Status> statusOptional = statusRepository.findById(dto.getIdStatus());
        Optional<ProjectType> projectTypeOptional = projectTypeRepository.findById(dto.getIdProjectType());
        if(!statusOptional.isPresent() || !projectTypeOptional.isPresent()){
            throw new RuntimeException("Incorrect identifiers: id:status: " + dto.getIdStatus()
                    + ", id:ProjectType:" + dto.getIdProjectType());

        }

        Status status = statusOptional.get();
        ProjectType projectType = projectTypeOptional.get();

        Project project = Project.of(dto);
        project.setProjectType(projectType);
        project.setStatus(status);

        return projectRepository.save(project);

    }

}
