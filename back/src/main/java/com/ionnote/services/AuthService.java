package com.ionnote.services;

import com.ionnote.dtos.JwtRequest;
import com.ionnote.dtos.user.GetUserDTO;
import com.ionnote.entities.User;
import com.ionnote.exceptions.UserNotFoundException;
import com.ionnote.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthService {
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;

    @Lazy
    private UserService userService;

    public String auth(JwtRequest authenticationRequest) {

        var user = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());

        authenticationManager.authenticate(user);

        var userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        return jwtTokenUtil.generateToken(userDetails);
    }

    public User getLoggedUser() throws UserNotFoundException {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var userEmail = authentication.getName();
        var dto = GetUserDTO.builder().email(userEmail).build();
        return userService.getUser(dto).orElseThrow(UserNotFoundException::new);

    }
}
