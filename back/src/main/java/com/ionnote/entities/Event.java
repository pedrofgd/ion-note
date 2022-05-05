package com.ionnote.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Document("Events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private String id;

    private String ownerId;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
}
