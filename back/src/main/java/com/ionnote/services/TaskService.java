package com.ionnote.services;

import com.ionnote.dtos.task.*;
import com.ionnote.entities.Task;
import com.ionnote.exceptions.ForbiddenException;
import com.ionnote.exceptions.TaskNotFoundException;
import com.ionnote.exceptions.UserNotFoundException;
import com.ionnote.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private AuthService authService;

    //Create
    public void createTask(CreateTaskDTO dto) throws UserNotFoundException {
        var loggedUser = authService.getLoggedUser();

        var tempTask = Task.builder()
                .uuid(UUID.randomUUID().toString())
                .ownerId(loggedUser.getUuid())
                .name(dto.getName())
                .deadline(dto.getDeadline())
                .completed(Boolean.FALSE)
                .build();

        taskRepository.save(tempTask);
    }

    //Read
    public TaskDTO readTask(ReadTaskDTO dto) throws TaskNotFoundException, UserNotFoundException, ForbiddenException {
        var task = taskRepository.findById(dto.getUuid()).orElseThrow(TaskNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getUuid().equals(task.getOwnerId())){
            throw new ForbiddenException();
        }
        var response = new TaskDTO();
        BeanUtils.copyProperties(task,response);
        return response;
    }

    public List<TaskDTO> readAllTasks() throws UserNotFoundException {
        var loggedUser = authService.getLoggedUser();
        var tasks = taskRepository.findAllByOwnerId(loggedUser.getUuid());
        return tasks.stream().map(task -> {
            var tempResponse = new TaskDTO();
            BeanUtils.copyProperties(task,tempResponse);
            return tempResponse;
        }).toList();
    }

    //Update
    public void updateTask(UpdateTaskDTO dto) throws TaskNotFoundException, UserNotFoundException, ForbiddenException {
        var task = taskRepository.findById(dto.getUuid()).orElseThrow(TaskNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getUuid().equals(task.getOwnerId())){
            throw new ForbiddenException();
        }
        BeanUtils.copyProperties(dto, task);
        taskRepository.save(task);
    }

    //Delete
    public void deleteTask(DeleteTaskDTO dto) throws TaskNotFoundException, UserNotFoundException, ForbiddenException {
        var task = taskRepository.findById(dto.getUuid()).orElseThrow(TaskNotFoundException::new);
        var loggedUser = authService.getLoggedUser();
        if (!loggedUser.getUuid().equals(task.getOwnerId())){
            throw new ForbiddenException();
        }
        taskRepository.delete(task);
    }

}
