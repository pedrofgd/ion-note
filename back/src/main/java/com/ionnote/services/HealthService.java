package com.ionnote.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class HealthService {
    public HashMap<String,String> check(){
        var healthCheck = new HashMap<String,String>();
        healthCheck.put("app","ion-note");
        healthCheck.put("time", LocalDateTime.now().toString());
        return healthCheck;
    }
}
