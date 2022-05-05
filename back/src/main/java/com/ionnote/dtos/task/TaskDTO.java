package com.ionnote.dtos.task;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private String uuid;
    private String name;
    private LocalDateTime deadline;
    private Boolean completed;
}
