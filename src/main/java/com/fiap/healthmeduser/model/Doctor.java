package com.fiap.healthmeduser.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "doctors")
public class Doctor {

    @Id
    private String id;
    private String name;
    private String cpf;
    private String crm;
    private String email;
    private String password;

}

