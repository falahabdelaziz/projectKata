package com.kata.compte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan({"com.kata.compte", "com.kata.compte.config"})
@EnableJpaRepositories("com.kata.compte.repository")
public class SocleKataCompteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocleKataCompteApplication.class, args);
    }

}
