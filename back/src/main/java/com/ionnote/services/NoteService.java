package com.ionnote.services;

import com.ionnote.dtos.note.*;
import com.ionnote.dtos.note.NoteDTO;
import com.ionnote.entities.Note;
import com.ionnote.exceptions.ForbiddenException;
import com.ionnote.exceptions.NoteNotFoundException;
import com.ionnote.exceptions.UserNotFoundException;
import com.ionnote.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NoteService {
    private NoteRepository noteRepository;
    private AuthService authService;

    //Create
    public void createNote(CreateNoteDTO dto) throws UserNotFoundException {
        var loggedUser = authService.getLoggedUser();
        var tempNote = Note.builder()
                .title(dto.getTitle())
                .subtitle(dto.getSubtitle())
                .description(dto.getDescription())
                .content(dto.getContent())
                .uuid(UUID.randomUUID().toString())
                .ownerId(loggedUser.getUuid())
                .createdAt(LocalDateTime.now())
                .build();

        noteRepository.save(tempNote);
    }

    //Read
    public NoteDTO readNote(ReadNoteDTO dto) throws NoteNotFoundException, UserNotFoundException, ForbiddenException {
        var note = noteRepository.findById(dto.getUuid()).orElseThrow(NoteNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getUuid().equals(note.getUuid())){
            throw new ForbiddenException();
        }
        var response = new NoteDTO();
        BeanUtils.copyProperties(note,response);
        return response;
    }

    public List<NoteDTO> readAllNotes() throws UserNotFoundException {
        var loggedUser = authService.getLoggedUser();
        var notes = noteRepository.findAllByOwnerId(loggedUser.getUuid());
        return notes.stream().map(note -> {
            var tempResponse = new NoteDTO();
            BeanUtils.copyProperties(note,tempResponse);
            return tempResponse;
        }).toList();
    }

    //Update
    public void updateNote(UpdateNoteDTO dto) throws NoteNotFoundException, UserNotFoundException, ForbiddenException {
        var note = noteRepository.findById(dto.getUuid()).orElseThrow(NoteNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getUuid().equals(note.getUuid())){
            throw new ForbiddenException();
        }
        BeanUtils.copyProperties(dto, note);
        noteRepository.save(note);
    }

    //Delete
    public void deleteNote(DeleteNoteDTO dto) throws NoteNotFoundException, UserNotFoundException, ForbiddenException {
        var note = noteRepository.findById(dto.getUuid()).orElseThrow(NoteNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getUuid().equals(note.getUuid())){
            throw new ForbiddenException();
        }
        noteRepository.delete(note);
    }
}
