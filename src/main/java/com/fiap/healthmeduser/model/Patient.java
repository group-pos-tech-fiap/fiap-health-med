package com.fiap.healthmeduser.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "patients")
public class Patient {

    @Id
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;

}
