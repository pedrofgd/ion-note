package com.ionnote.services;

import com.ionnote.dtos.event.CreateEventDTO;
import com.ionnote.dtos.event.DeleteEventDTO;
import com.ionnote.dtos.event.ReadEventDTO;
import com.ionnote.dtos.event.UpdateEventDTO;
import com.ionnote.entities.Event;
import com.ionnote.exceptions.EventNotFoundException;
import com.ionnote.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private EventRepository eventRepository;

    //Create
    public void createEvent(CreateEventDTO dto) {
        var tempEvent = Event.builder()
                .uuid(UUID.randomUUID())
                .name(dto.getName())
                .start(dto.getStart())
                .end(dto.getEnd())
                .build();

        eventRepository.save(tempEvent);
    }

    //Read
    public Event readEvent(ReadEventDTO dto) throws EventNotFoundException {
        var optionalEvent = eventRepository.findById(dto.getUuid());

        if (optionalEvent.isEmpty()) {
            throw new EventNotFoundException();
        }

        return optionalEvent.get();
    }

    public List<Event> readAllEvents() {
        return eventRepository.findAll();
    }

    //Update
    public void updateEvent(UpdateEventDTO dto) throws EventNotFoundException {
        var optionalEvent = eventRepository.findById(dto.getUuid());

        if (optionalEvent.isEmpty()) {
            throw new EventNotFoundException();
        }

        var event = optionalEvent.get();
        BeanUtils.copyProperties(dto, event);
        eventRepository.save(event);
    }

    //Delete
    public void deleteEvent(DeleteEventDTO dto) throws EventNotFoundException {
        var optionalEvent = eventRepository.findById(dto.getUuid());

        if (optionalEvent.isEmpty()) {
            throw new EventNotFoundException();
        }

        var event = optionalEvent.get();
        eventRepository.delete(event);
    }

}
