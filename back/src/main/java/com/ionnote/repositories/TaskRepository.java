package com.ionnote.repositories;

import com.ionnote.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TaskRepository extends MongoRepository<Task, UUID> {

}
