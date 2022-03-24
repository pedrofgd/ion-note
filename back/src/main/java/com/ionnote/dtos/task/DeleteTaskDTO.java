package com.ionnote.dtos.task;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTaskDTO {
    private UUID uuid;
}
