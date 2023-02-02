package com.example.dobaerangshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DobaerangShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DobaerangShopApplication.class, args);
    }

}
