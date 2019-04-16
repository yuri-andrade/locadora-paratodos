package com.desafio.locadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LocadoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocadoraApplication.class, args);
    }

}

