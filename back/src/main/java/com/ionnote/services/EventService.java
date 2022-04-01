package com.ionnote.services;

import com.ionnote.dtos.event.*;
import com.ionnote.dtos.event.EventDTO;
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
    public EventDTO readEvent(ReadEventDTO dto) throws EventNotFoundException {
        var event = eventRepository.findById(dto.getUuid()).orElseThrow(EventNotFoundException::new);
        var response = new EventDTO();
        BeanUtils.copyProperties(event,response);
        return response;
    }

    public List<EventDTO> readAllEvents() {
        var tasks = eventRepository.findAll();
        return tasks.stream().map(event -> {
            var tempResponse = new EventDTO();
            BeanUtils.copyProperties(event,tempResponse);
            return tempResponse;
        }).toList();
    }

    //Update
    public void updateEvent(UpdateEventDTO dto) throws EventNotFoundException {
        var event = eventRepository.findById(dto.getUuid()).orElseThrow(EventNotFoundException::new);
        BeanUtils.copyProperties(dto, event);
        eventRepository.save(event);
    }

    //Delete
    public void deleteEvent(DeleteEventDTO dto) throws EventNotFoundException {
        var event = eventRepository.findById(dto.getUuid()).orElseThrow(EventNotFoundException::new);
        eventRepository.delete(event);
    }

}
