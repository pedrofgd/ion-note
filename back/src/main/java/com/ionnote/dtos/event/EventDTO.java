package com.ionnote.dtos.event;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private String uuid;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
}
