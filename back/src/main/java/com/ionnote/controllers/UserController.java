package com.ionnote.controllers;

import com.ionnote.dtos.user.CreateUserDTO;
import com.ionnote.dtos.ResponseDTO;
import com.ionnote.dtos.user.GetUserDTO;
import com.ionnote.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private static final String SUCCESS = "success";

    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createUser(@RequestBody CreateUserDTO dto) {
        var response = new ResponseDTO();
        try {
            userService.createUser(dto);
            response.setMessage(SUCCESS);
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

    @GetMapping()
    public ResponseEntity<ResponseDTO> getUser(@RequestBody GetUserDTO dto){
        var response = new ResponseDTO();
        try {
            response.setData(userService.getUser(dto));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("GET USER OPERATION FAILED::{}",dto);
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
