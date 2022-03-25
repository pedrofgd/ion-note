package com.ionnote.repositories;

import com.ionnote.entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface NoteRepository extends MongoRepository<Note, UUID> {
}
