package com.ionnote.services;

import com.ionnote.dtos.note.CreateNoteDTO;
import com.ionnote.dtos.note.DeleteNoteDTO;
import com.ionnote.dtos.note.ReadNoteDTO;
import com.ionnote.dtos.note.UpdateNoteDTO;
import com.ionnote.entities.Note;
import com.ionnote.exceptions.NoteNotFoundException;
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

    //Create
    public void createNote(CreateNoteDTO dto) {
        var tempNote = Note.builder()
                .title(dto.getTitle())
                .subtitle(dto.getSubtitle())
                .description(dto.getDescription())
                .content(dto.getContent())
                .uuid(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .build();

        noteRepository.save(tempNote);
    }

    //Read
    public Note readNote(ReadNoteDTO dto) throws NoteNotFoundException {
        var optionalNote = noteRepository.findById(dto.getUuid());

        if (optionalNote.isEmpty()) {
            throw new NoteNotFoundException();
        }

        return optionalNote.get();
    }

    public List<Note> readAllNotes() {
        return noteRepository.findAll();
    }

    //Update
    public void updateNote(UpdateNoteDTO dto) throws NoteNotFoundException {
        var optionalNote = noteRepository.findById(dto.getUuid());

        if (optionalNote.isEmpty()) {
            throw new NoteNotFoundException();
        }

        var note = optionalNote.get();
        BeanUtils.copyProperties(dto, note);
        noteRepository.save(note);
    }

    //Delete
    public void deleteNote(DeleteNoteDTO dto) throws NoteNotFoundException {
        var optionalNote = noteRepository.findById(dto.getUuid());

        if (optionalNote.isEmpty()) {
            throw new NoteNotFoundException();
        }

        var note = optionalNote.get();
        noteRepository.delete(note);
    }
}
