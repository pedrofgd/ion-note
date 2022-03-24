package com.ionnote.dtos.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDTO {
    private String email;
}
