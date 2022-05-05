package com.ionnote.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("Users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String uuid;

    private String name;
    private String email;
    private String password;
}
