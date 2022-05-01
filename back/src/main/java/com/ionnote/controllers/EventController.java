package com.ionnote.controllers;

import com.ionnote.constants.ResponseConstants;
import com.ionnote.dtos.ResponseDTO;
import com.ionnote.dtos.event.CreateEventDTO;
import com.ionnote.dtos.event.DeleteEventDTO;
import com.ionnote.dtos.event.ReadEventDTO;
import com.ionnote.dtos.event.UpdateEventDTO;
import com.ionnote.exceptions.EventNotFoundException;
import com.ionnote.services.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("event")
@AllArgsConstructor
public class EventController {
    private EventService eventService;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> createEvent(@RequestBody CreateEventDTO dto){
        var response = new ResponseDTO();
        try {
            eventService.createEvent(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("CREATE EVENT OPERATION FAILED::{}",dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseDTO> readEvent(@RequestBody ReadEventDTO dto){
        var response = new ResponseDTO();
        try {
            response.setData(eventService.readEvent(dto));
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (EventNotFoundException e){
            log.error("READ EVENT OPERATION FAILED ({})::{}", ResponseConstants.EVENT_NOT_FOUND.getMessage(),dto.getUuid());
            e.printStackTrace();
            response.setMessage(ResponseConstants.EVENT_NOT_FOUND.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("READ EVENT OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateEvent(@RequestBody UpdateEventDTO dto){
        var response = new ResponseDTO();
        try {
            eventService.updateEvent(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (EventNotFoundException e){
            log.error("UPDATE EVENT OPERATION FAILED ({})::{}", ResponseConstants.EVENT_NOT_FOUND.getMessage(),dto.getUuid());
            e.printStackTrace();
            response.setMessage(ResponseConstants.EVENT_NOT_FOUND.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("UPDATE EVENT OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteEvent(@RequestBody DeleteEventDTO dto){
        var response = new ResponseDTO();
        try {
            eventService.deleteEvent(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (EventNotFoundException e){
            log.error("DELETE EVENT OPERATION FAILED ({})::{}", ResponseConstants.EVENT_NOT_FOUND.getMessage(),dto.getUuid());
            e.printStackTrace();
            response.setMessage(ResponseConstants.EVENT_NOT_FOUND.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("DELETE EVENT OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> readAllEvents(){
        var response = new ResponseDTO();
        try {
            response.setData(eventService.readAllEvents());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("GET ALL EVENTS OPERATION FAILED");
            e.printStackTrace();
            response.setMessage(ResponseConstants.UNKNOWN_ERROR.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
