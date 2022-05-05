package com.ionnote.repositories;

import com.ionnote.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends MongoRepository<Event, UUID> {
    List<Event> findAllByOwnerId(String id);
}
