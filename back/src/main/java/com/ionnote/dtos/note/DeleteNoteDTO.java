package com.ionnote.dtos.note;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteNoteDTO {
    private UUID uuid;
}
