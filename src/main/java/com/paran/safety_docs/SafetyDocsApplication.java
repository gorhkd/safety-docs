package com.paran.safety_docs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SafetyDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyDocsApplication.class, args);
    }

}
