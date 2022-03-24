package com.ionnote.controllers;

import com.ionnote.dtos.ResponseDTO;
import com.ionnote.dtos.task.CreateTaskDTO;
import com.ionnote.dtos.task.DeleteTaskDTO;
import com.ionnote.dtos.task.ReadTaskDTO;
import com.ionnote.dtos.task.UpdateTaskDTO;
import com.ionnote.exceptions.TaskNotFoundException;
import com.ionnote.services.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("task")
@AllArgsConstructor
public class TaskController {
    private static final String SUCCESS = "SUCCESS";
    private static final String TASK_NOT_FOUND = "TASK NOT FOUND";
    private static final String UNKNOWN_ERROR = "UNKNOWN ERROR";


    private TaskService taskService;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> createTask(@RequestBody CreateTaskDTO dto){
        var response = new ResponseDTO();
        try {
            taskService.createTask(dto);
            response.setMessage(SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("CREATE TASK OPERATION FAILED::{}",dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseDTO> readTask(@RequestBody ReadTaskDTO dto){
        var response = new ResponseDTO();
        try {
            response.setData(taskService.readTask(dto));
            response.setMessage(SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TaskNotFoundException e){
            log.error("READ TASK OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getUuid());
            e.printStackTrace();
            response.setMessage(TASK_NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("READ TASK OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateTask(@RequestBody UpdateTaskDTO dto){
        var response = new ResponseDTO();
        try {
            taskService.updateTask(dto);
            response.setMessage(SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TaskNotFoundException e){
            log.error("UPDATE TASK OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getUuid());
            e.printStackTrace();
            response.setMessage(TASK_NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("UPDATE TASK OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteTask(@RequestBody DeleteTaskDTO dto){
        var response = new ResponseDTO();
        try {
            taskService.deleteTask(dto);
            response.setMessage(SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TaskNotFoundException e){
            log.error("DELETE TASK OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getUuid());
            e.printStackTrace();
            response.setMessage(TASK_NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("DELETE TASK OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> readAllTasks(){
        var response = new ResponseDTO();
        try {
            response.setData(taskService.readAllTasks());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("GET ALL TASKS OPERATION FAILED");
            e.printStackTrace();
            response.setMessage(UNKNOWN_ERROR);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
