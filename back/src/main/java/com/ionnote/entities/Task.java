package com.ionnote.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Document("Tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private UUID uuid;

    private String name;
    private LocalDateTime deadline;
    private Boolean completed;

}
