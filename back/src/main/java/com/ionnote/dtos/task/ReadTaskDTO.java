package com.ionnote.dtos.task;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadTaskDTO {
    private UUID uuid;
}
