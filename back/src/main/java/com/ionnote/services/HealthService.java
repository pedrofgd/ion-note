package com.ionnote.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class HealthService {
    public Map<String, String> check() {
        var healthCheck = new HashMap<String, String>();
        healthCheck.put("app", "ion-note");
        healthCheck.put("time", LocalDateTime.now().toString());
        return healthCheck;
    }
}
