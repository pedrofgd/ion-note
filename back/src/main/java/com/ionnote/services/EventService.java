package com.ionnote.services;

import com.ionnote.dtos.event.*;
import com.ionnote.dtos.event.EventDTO;
import com.ionnote.entities.Event;
import com.ionnote.exceptions.EventNotFoundException;
import com.ionnote.exceptions.ForbiddenException;
import com.ionnote.exceptions.UserNotFoundException;
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
    private AuthService authService;

    //Create
    public void createEvent(CreateEventDTO dto) throws UserNotFoundException {
        var loggedUser = authService.getLoggedUser();
        var tempEvent = Event.builder()
                .id(UUID.randomUUID().toString())
                .ownerId(loggedUser.getId())
                .name(dto.getName())
                .start(dto.getStart())
                .end(dto.getEnd())
                .build();

        eventRepository.save(tempEvent);
    }

    //Read
    public EventDTO readEvent(ReadEventDTO dto) throws EventNotFoundException, UserNotFoundException, ForbiddenException {
        var event = eventRepository.findById(dto.getUuid()).orElseThrow(EventNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getId().equals(event.getId())){
            throw new ForbiddenException();
        }
        var response = new EventDTO();
        BeanUtils.copyProperties(event,response);
        return response;
    }

    public List<EventDTO> readAllEvents() throws UserNotFoundException {
        var loggedUser = authService.getLoggedUser();
        var events = eventRepository.findAllByOwnerId(loggedUser.getId());
        return events.stream().map(event -> {
            var tempResponse = new EventDTO();
            BeanUtils.copyProperties(event,tempResponse);
            return tempResponse;
        }).toList();
    }

    //Update
    public void updateEvent(UpdateEventDTO dto) throws EventNotFoundException, UserNotFoundException, ForbiddenException {
        var event = eventRepository.findById(dto.getUuid()).orElseThrow(EventNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getId().equals(event.getId())){
            throw new ForbiddenException();
        }
        BeanUtils.copyProperties(dto, event);
        eventRepository.save(event);
    }

    //Delete
    public void deleteEvent(DeleteEventDTO dto) throws EventNotFoundException, UserNotFoundException, ForbiddenException {
        var event = eventRepository.findById(dto.getUuid()).orElseThrow(EventNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getId().equals(event.getId())){
            throw new ForbiddenException();
        }
        eventRepository.delete(event);
    }

}
