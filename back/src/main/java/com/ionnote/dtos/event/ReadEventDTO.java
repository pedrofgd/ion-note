package com.ionnote.dtos.event;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadEventDTO {
    private UUID uuid;
}
