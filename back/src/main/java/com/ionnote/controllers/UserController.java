package com.ionnote.controllers;

import com.ionnote.constants.ResponseConstants;
import com.ionnote.dtos.ResponseDTO;
import com.ionnote.exceptions.UserNotFoundException;
import com.ionnote.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private AuthService authService;

    @GetMapping()
    public ResponseEntity<ResponseDTO> getUser(){
        var response = new ResponseDTO();
        try {
            response.setData(authService.getLoggedUser());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            log.error("GET USER OPERATION FAILED ({})::{}", ResponseConstants.USER_NOT_FOUND.getMessage(),e.getMessage());
            e.printStackTrace();
            response.setMessage(e.getMessage());
        }
        catch (Exception e) {
            log.error("GET USER OPERATION FAILED::{}",e.getMessage());
            e.printStackTrace();
            response.setMessage(e.getMessage());
        }
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
