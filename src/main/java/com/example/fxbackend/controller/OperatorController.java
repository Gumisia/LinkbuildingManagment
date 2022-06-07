package com.example.fxbackend.controller;

import com.example.fxbackend.dto.OperatorAuthenticationResultDto;
import com.example.fxbackend.dto.OperatorCredentialsDto;
import com.example.fxbackend.entity.Operator;
import com.example.fxbackend.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OperatorController {
    private final OperatorRepository operatorRepository;

    @PostMapping("/operators")
    public Operator newOperator(@RequestBody Operator newOperator){
        return operatorRepository.save(newOperator);
    }

    @GetMapping("/operators")
    public List<Operator> operatorsList(){
        return operatorRepository.findAll();
    }

    @DeleteMapping("/operators")
    public ResponseEntity deleteOperator(@RequestBody Long idOperator){
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify_operator_credentials")
    public OperatorAuthenticationResultDto verifyOperatorCredentials(@RequestBody OperatorCredentialsDto operatorCredentialsDto){
        Optional<Operator> operatorOptional = operatorRepository.findByLogin(operatorCredentialsDto.getLogin());

        //empty
        if(!operatorOptional.isPresent()){
            return OperatorAuthenticationResultDto.createUnauthenticatedDto();
        }

        //not equals
        Operator operator = operatorOptional.get();
        if(!operator.getPassword().equals(operatorCredentialsDto.getPasswaord())){
            return OperatorAuthenticationResultDto.createUnauthenticatedDto();
        }
        //same login data
        else {
            return OperatorAuthenticationResultDto.of(operator);
        }
    }
}
