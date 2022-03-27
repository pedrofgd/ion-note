package com.ionnote.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Document("Events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private UUID uuid;

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
}
