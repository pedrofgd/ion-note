package com.ionnote.controllers;

import com.ionnote.dtos.ResponseDTO;
import com.ionnote.dtos.note.CreateNoteDTO;
import com.ionnote.dtos.note.DeleteNoteDTO;
import com.ionnote.dtos.note.ReadNoteDTO;
import com.ionnote.dtos.note.UpdateNoteDTO;
import com.ionnote.exceptions.NoteNotFoundException;
import com.ionnote.services.NoteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("note")
@AllArgsConstructor
public class NoteController {
        private static final String SUCCESS = "SUCCESS";
        private static final String NOTE_NOT_FOUND = "NOTE NOT FOUND";
        private static final String UNKNOWN_ERROR = "UNKNOWN ERROR";


        private NoteService noteService;

        @PostMapping("create")
        public ResponseEntity<ResponseDTO> createNote(@RequestBody CreateNoteDTO dto){
            var response = new ResponseDTO();
            try {
                noteService.createNote(dto);
                response.setMessage(SUCCESS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (Exception e) {
                log.error("CREATE NOTE OPERATION FAILED::{}",dto.toString());
                e.printStackTrace();
                response.setMessage(e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/read")
        public ResponseEntity<ResponseDTO> readNote(@RequestBody ReadNoteDTO dto){
            var response = new ResponseDTO();
            try {
                response.setData(noteService.readNote(dto));
                response.setMessage(SUCCESS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (NoteNotFoundException e){
                log.error("READ NOTE OPERATION FAILED ({})::{}",NOTE_NOT_FOUND,dto.getUuid());
                e.printStackTrace();
                response.setMessage(NOTE_NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            catch (Exception e) {
                log.error("READ NOTE OPERATION FAILED::{}",dto.getUuid());
                e.printStackTrace();
                response.setMessage(e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/update")
        public ResponseEntity<ResponseDTO> updateNote(@RequestBody UpdateNoteDTO dto){
            var response = new ResponseDTO();
            try {
                noteService.updateNote(dto);
                response.setMessage(SUCCESS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (NoteNotFoundException e){
                log.error("UPDATE NOTE OPERATION FAILED ({})::{}",NOTE_NOT_FOUND,dto.getUuid());
                e.printStackTrace();
                response.setMessage(NOTE_NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            catch (Exception e) {
                log.error("UPDATE NOTE OPERATION FAILED::{}",dto.getUuid());
                e.printStackTrace();
                response.setMessage(e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/delete")
        public ResponseEntity<ResponseDTO> deleteNote(@RequestBody DeleteNoteDTO dto){
            var response = new ResponseDTO();
            try {
                noteService.deleteNote(dto);
                response.setMessage(SUCCESS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (NoteNotFoundException e){
                log.error("DELETE NOTE OPERATION FAILED ({})::{}",NOTE_NOT_FOUND,dto.getUuid());
                e.printStackTrace();
                response.setMessage(NOTE_NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            catch (Exception e) {
                log.error("DELETE NOTE OPERATION FAILED::{}",dto.getUuid());
                e.printStackTrace();
                response.setMessage(e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping
        public ResponseEntity<ResponseDTO> readAllNotes(){
            var response = new ResponseDTO();
            try {
                response.setData(noteService.readAllNotes());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (Exception e){
                log.error("GET ALL NOTES OPERATION FAILED");
                e.printStackTrace();
                response.setMessage(UNKNOWN_ERROR);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }

}
