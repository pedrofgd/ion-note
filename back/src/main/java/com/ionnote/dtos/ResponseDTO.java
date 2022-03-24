package com.ionnote.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private Object data;
    private String message;
    private String[] errors;
}
