package com.ionnote.controllers;

import com.ionnote.constants.ResponseConstants;
import com.ionnote.dtos.ResponseDTO;
import com.ionnote.dtos.task.CreateTaskDTO;
import com.ionnote.dtos.task.DeleteTaskDTO;
import com.ionnote.dtos.task.ReadTaskDTO;
import com.ionnote.dtos.task.UpdateTaskDTO;
import com.ionnote.exceptions.ForbiddenException;
import com.ionnote.exceptions.TaskNotFoundException;
import com.ionnote.exceptions.UserNotFoundException;
import com.ionnote.services.AuthService;
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

    private TaskService taskService;
    private AuthService authService;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> createTask(@RequestBody CreateTaskDTO dto){
        var response = new ResponseDTO();
        try {
            taskService.createTask(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            log.error("CREATE TASK OPERATION FAILED ({})::{}",ResponseConstants.USER_NOT_FOUND.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
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
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TaskNotFoundException e){
            log.error("READ TASK OPERATION FAILED ({})::{}", ResponseConstants.TASK_NOT_FOUND.getMessage(),dto.getUuid());
            e.printStackTrace();
            response.setMessage(ResponseConstants.TASK_NOT_FOUND.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (UserNotFoundException e) {
            log.error("READ TASK OPERATION FAILED ({})::{}",ResponseConstants.USER_NOT_FOUND.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (ForbiddenException e) {
            log.error("READ TASK OPERATION FAILED ({})::{}",ResponseConstants.FORBIDDEN.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
        catch (Exception e) {
            log.error("READ TASK OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateTask(@RequestBody UpdateTaskDTO dto){
        var response = new ResponseDTO();
        try {
            taskService.updateTask(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TaskNotFoundException e){
            log.error("UPDATE TASK OPERATION FAILED ({})::{}", ResponseConstants.TASK_NOT_FOUND.getMessage(),dto.getUuid());
            e.printStackTrace();
            response.setMessage(ResponseConstants.TASK_NOT_FOUND.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (UserNotFoundException e) {
            log.error("UPDATE TASK OPERATION FAILED ({})::{}",ResponseConstants.USER_NOT_FOUND.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (ForbiddenException e) {
            log.error("UPDATE TASK OPERATION FAILED ({})::{}",ResponseConstants.FORBIDDEN.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
        catch (Exception e) {
            log.error("UPDATE TASK OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteTask(@RequestBody DeleteTaskDTO dto){
        var response = new ResponseDTO();
        try {
            taskService.deleteTask(dto);
            response.setMessage(ResponseConstants.SUCCESS.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TaskNotFoundException e){
            log.error("DELETE TASK OPERATION FAILED ({})::{}", ResponseConstants.TASK_NOT_FOUND.getMessage(),dto.getUuid());
            e.printStackTrace();
            response.setMessage(ResponseConstants.TASK_NOT_FOUND.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (UserNotFoundException e) {
            log.error("DELETE TASK OPERATION FAILED ({})::{}",ResponseConstants.USER_NOT_FOUND.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (ForbiddenException e) {
            log.error("DELETE TASK OPERATION FAILED ({})::{}",ResponseConstants.FORBIDDEN.getMessage(),dto.toString());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
        catch (Exception e) {
            log.error("DELETE TASK OPERATION FAILED::{}",dto.getUuid());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> readAllTasks(){
        var response = new ResponseDTO();
        try {
            log.info(authService.getLoggedUser().getUuid());
            response.setData(taskService.readAllTasks());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            log.error("GET ALL TASKS  OPERATION FAILED ({})::",ResponseConstants.USER_NOT_FOUND.getMessage());
            e.printStackTrace();
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            log.error("GET ALL TASKS OPERATION FAILED");
            e.printStackTrace();
            response.setMessage(ResponseConstants.UNKNOWN_ERROR.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
