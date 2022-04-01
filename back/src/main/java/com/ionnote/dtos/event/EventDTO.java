package com.ionnote.dtos.event;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private UUID uuid;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
}
