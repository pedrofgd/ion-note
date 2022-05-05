package com.ionnote.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Document("Notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    private String id;

    private String ownerId;
    private String title;
    private String subtitle;
    private String description;
    private Object content;
    private LocalDateTime createdAt;
}
