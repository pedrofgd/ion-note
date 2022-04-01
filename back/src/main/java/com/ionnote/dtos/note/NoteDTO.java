package com.ionnote.dtos.note;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    private UUID uuid;
    private String title;
    private String subtitle;
    private String description;
    private Object content;
    private LocalDateTime createdAt;
}
