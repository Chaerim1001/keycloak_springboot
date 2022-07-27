package com.example.keycloak_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan({"com.example.controller", "com.example.service", "com.example.security"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class KeycloakPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakPracApplication.class, args);
    }

}
