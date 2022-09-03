package com.example.keycloak_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan({"com.example.controller", "com.example.service", "com.example.security"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@PropertySource("classpath:/env.properties")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class KeycloakPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakPracApplication.class, args);
    }

}
