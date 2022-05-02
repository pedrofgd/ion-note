package com.ionnote.controllers;


import com.ionnote.dtos.JwtRequest;
import com.ionnote.dtos.ResponseDTO;
import com.ionnote.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> createAuthenticationToken(@RequestBody JwtRequest dto) {
        var response = new ResponseDTO();
        response.setData(authService.auth(dto));
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}