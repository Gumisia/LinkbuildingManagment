package com.example.fxbackend.controller;

import com.example.fxbackend.dto.EmployeeDto;
import com.example.fxbackend.dto.ProjectDto;
import com.example.fxbackend.dto.ProjectSaveDto;
import com.example.fxbackend.entity.Employee;
import com.example.fxbackend.entity.Project;
import com.example.fxbackend.repository.EmployeeRepository;
import com.example.fxbackend.repository.ProjectRepository;
import com.example.fxbackend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectService projectService;

    @PostMapping("/projects")
    public ProjectDto newEmployee(@RequestBody ProjectSaveDto dto){

        return ProjectDto.of(projectService.saveProject(dto));
    }

    @GetMapping("/projects")
    public List<ProjectDto> projectsList(){
        return projectRepository.findAll()
                .stream()
                .map(ProjectDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/projects/{idProject}")
    public ProjectDto getProject(@PathVariable Long idEmployee) throws InterruptedException {
        Optional<Project> optionalProject = projectRepository.findById(idEmployee);
        return ProjectDto.of(optionalProject.get());
    }


    @DeleteMapping("/projects")
    public ResponseEntity deleteProject(@RequestBody Long idProject){
        projectRepository.deleteById(idProject);
        return ResponseEntity.ok().build();
    }
}
