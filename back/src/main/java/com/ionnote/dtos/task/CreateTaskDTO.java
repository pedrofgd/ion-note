package com.ionnote.dtos.task;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDTO {
    private String name;
    private LocalDateTime deadline;
}
