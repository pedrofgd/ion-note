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
    @Id
    private UUID uuid;

    private String ownerId;
    private String title;
    private String subtitle;
    private String description;
    private Object content;
    private LocalDateTime createdAt;
}
