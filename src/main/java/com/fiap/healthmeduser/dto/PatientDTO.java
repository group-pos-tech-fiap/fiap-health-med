package com.fiap.healthmeduser.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private String name;
    private String cpf;
    private String email;
    private String password;
}
