package com.example.fxbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.fxbackend.dto.StatusModuleDto;
import com.example.fxbackend.entity.Status;
import com.example.fxbackend.repository.StatusRepository;
import com.example.fxbackend.service.StatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StatusController {

    private final StatusRepository statusRepository;
    private final StatusService statusService;

    @PostMapping("/statuses")
    Status newStatus(@RequestBody Status status){
        return statusRepository.save(status);
    }

    @GetMapping("/statuses")
    List<Status> listStatuses(){
        return statusRepository.findAll();
    }

    @DeleteMapping("/statuses")
    ResponseEntity deleteStatus(@RequestBody Long idStatus){
        statusRepository.deleteById(idStatus);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statuses_module_data")
    public StatusModuleDto getStatusModuleData(@RequestParam Optional<String> idStatus){
        if(idStatus.isPresent()){
            return statusService.getStatusModuleData(Long.parseLong(idStatus.get()));
        } else {
            return statusService.getStatusModuleData();
        }
    }

}
