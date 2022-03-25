package com.ionnote.dtos.note;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteDTO {
    private String title;
    private String subtitle;
    private String description;
    private Object content;
}
