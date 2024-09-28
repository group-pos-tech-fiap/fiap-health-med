package com.fiap.healthmeduser;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Health Med USER - FIAP", description = "Microservico responsavel pelos usuários", version = "v1"))
public class HealthMedUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthMedUserApplication.class, args);
    }

}
