package com.ionnote.services;

import com.ionnote.dtos.task.*;
import com.ionnote.entities.Task;
import com.ionnote.exceptions.TaskNotFoundException;
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

    //Create
    public void createTask(CreateTaskDTO dto) {
        var tempTask = Task.builder()
                .uuid(UUID.randomUUID())
                .name(dto.getName())
                .deadline(dto.getDeadline())
                .completed(Boolean.FALSE)
                .build();

        taskRepository.save(tempTask);
    }

    //Read
    public TaskDTO readTask(ReadTaskDTO dto) throws TaskNotFoundException {
        var task = taskRepository.findById(dto.getUuid()).orElseThrow(TaskNotFoundException::new);
        var response = new TaskDTO();
        BeanUtils.copyProperties(task,response);
        return response;
    }

    public List<TaskDTO> readAllTasks() {
        var tasks = taskRepository.findAll();
        return tasks.stream().map(task -> {
            var tempResponse = new TaskDTO();
            BeanUtils.copyProperties(task,tempResponse);
            return tempResponse;
        }).toList();
    }

    //Update
    public void updateTask(UpdateTaskDTO dto) throws TaskNotFoundException {
        var task = taskRepository.findById(dto.getUuid()).orElseThrow(TaskNotFoundException::new);
        BeanUtils.copyProperties(dto, task);
        taskRepository.save(task);
    }

    //Delete
    public void deleteTask(DeleteTaskDTO dto) throws TaskNotFoundException {
        var task = taskRepository.findById(dto.getUuid()).orElseThrow(TaskNotFoundException::new);
        taskRepository.delete(task);
    }

}
