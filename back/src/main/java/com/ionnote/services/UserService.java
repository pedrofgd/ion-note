package com.ionnote.services;

import com.ionnote.dtos.user.CreateUserDTO;
import com.ionnote.dtos.user.GetUserDTO;
import com.ionnote.entities.User;
import com.ionnote.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void createUser(CreateUserDTO dto) {
        var tempUser = User.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .email(dto.getEmail())
                .token(dto.getPassword())
                .salt(UUID.randomUUID())
                .build();

        userRepository.save(tempUser);
    }

    public Optional<User> getUser(GetUserDTO dto) {
        return userRepository.findByEmail(dto.getEmail());
    }
}


