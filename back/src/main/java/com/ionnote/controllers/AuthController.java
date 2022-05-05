package com.ionnote.controllers;


import com.ionnote.constants.ResponseConstants;
import com.ionnote.dtos.JwtRequest;
import com.ionnote.dtos.ResponseDTO;
import com.ionnote.dtos.user.CreateUserDTO;
import com.ionnote.services.AuthService;
import com.ionnote.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<ResponseDTO> createAuthenticationToken(@RequestBody JwtRequest dto) {
        var response = new ResponseDTO();
        response.setData(authService.auth(dto));
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody CreateUserDTO dto) {
        var response = new ResponseDTO();
        try {
            userService.createUser(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (DuplicateKeyException e){
            log.error("CREATE USER OPERATION FAILED (EMAIL ALREADY IN USE)::{}",dto.getEmail());
            e.printStackTrace();
            response.setMessage("This email is already in use =(");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("CREATE USER OPERATION FAILED::{}",dto.getEmail());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}