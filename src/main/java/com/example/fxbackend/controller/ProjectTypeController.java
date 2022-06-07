package com.example.fxbackend.controller;

import com.example.fxbackend.dto.ProjectTypeDto;
import com.example.fxbackend.entity.ProjectType;
import com.example.fxbackend.repository.ProjectTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProjectTypeController {
    private final ProjectTypeRepository ProjectTypeRepository;

    @PostMapping("/project_types")
    public ProjectType newProjectType(@RequestBody ProjectType newProjectType){
        return ProjectTypeRepository.save(newProjectType);
    }

    @GetMapping("/project_types")
    public List<ProjectTypeDto> projectTypeList(){

        return ProjectTypeRepository.findAll().stream().map(ProjectTypeDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/project_types")
    public ResponseEntity deleteProjectType(@RequestBody Long idProjectType){
        ProjectTypeRepository.deleteById(idProjectType);
        return ResponseEntity.ok().build();
    }
}
