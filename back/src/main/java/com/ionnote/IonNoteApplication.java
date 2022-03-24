package com.ionnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class IonNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(IonNoteApplication.class, args);
    }

}
