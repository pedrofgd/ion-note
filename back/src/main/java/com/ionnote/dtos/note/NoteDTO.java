package com.ionnote.dtos.note;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    private String id;
    private String title;
    private String subtitle;
    private String description;
    private Object content;
    private LocalDateTime createdAt;
}
