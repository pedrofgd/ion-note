package com.ionnote.controllers;


import com.ionnote.services.HealthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class HealthController {
    private HealthService healthService;

    @GetMapping
    public ResponseEntity<HashMap<String,String>> healthCheck(){
        return new ResponseEntity<>(healthService.check(), HttpStatus.OK);
    }
}
