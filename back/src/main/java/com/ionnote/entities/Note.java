package com.ionnote.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Document("Notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private String title;
    private String subtitle;
    private String description;
    private Object content;

    @Id
    private UUID uuid;

    private LocalDateTime createdAt;
}
