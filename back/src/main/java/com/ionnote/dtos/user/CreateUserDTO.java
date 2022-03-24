package com.ionnote.dtos.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;
}
