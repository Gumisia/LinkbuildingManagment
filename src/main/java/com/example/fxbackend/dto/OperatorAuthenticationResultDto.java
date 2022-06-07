package com.example.fxbackend.dto;

import com.example.fxbackend.entity.Operator;
import lombok.Data;

@Data
public class OperatorAuthenticationResultDto {
    private Long idOperator;
    private String firstname;
    private String lastname;
    private boolean authenticated;

    public static OperatorAuthenticationResultDto createUnauthenticatedDto(){
        OperatorAuthenticationResultDto dto = new OperatorAuthenticationResultDto();
        dto.setAuthenticated((false));
        return dto;
    }

    public static OperatorAuthenticationResultDto of(Operator operator){
        OperatorAuthenticationResultDto dto = new OperatorAuthenticationResultDto();
        dto.setAuthenticated(true);
        dto.setFirstname(operator.getEmployee().getFirstname());
        dto.setLastname(operator.getEmployee().getLastname());
        dto.setIdOperator(operator.getIdOperator());
        return dto;
    }

}
