package com.ionnote.dtos.task;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private UUID uuid;
    private String name;
    private LocalDateTime deadline;
    private Boolean completed;
}
