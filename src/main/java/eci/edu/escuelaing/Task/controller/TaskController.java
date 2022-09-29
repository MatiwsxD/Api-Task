package eci.edu.escuelaing.Task.controller;

import eci.edu.escuelaing.Task.dto.TaskDto;
import eci.edu.escuelaing.Task.entities.Task;
import eci.edu.escuelaing.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;


@RestController
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        //TODO implement this method using UserService
        List<Task> users =taskService.getAll();
        ArrayList<TaskDto> usersDto = new ArrayList<TaskDto>();
        for(int i = 0; i<users.size(); i++){
            usersDto.add(convertToTaskDto(users.get(i)));
            //System.out.println(users.get(i).getId()); Los id se generan aleatoreamente, con esto los puede ver
        }
        return new ResponseEntity<List<TaskDto>>(usersDto, HttpStatus.ACCEPTED);
    }
    @GetMapping( "/{id}" )
    public ResponseEntity<TaskDto> findById( @PathVariable String id ) {

        //TODO implement this method using UserService
        return new ResponseEntity<>(convertToTaskDto(taskService.findById(id)),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<TaskDto> create( @RequestBody TaskDto taskDto ) {
        //TODO implement this method using UserService
        taskDto.setDueDate(new Date());
        Task user =convertToTask(taskDto);
        System.out.println(user.getId());
        taskService.create(user);
        return new ResponseEntity<>(taskDto,HttpStatus.ACCEPTED);
    }
    @PutMapping( "/{id}" )
    public ResponseEntity<TaskDto> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
        //TODO implement this method using UserService
        Task taskN = convertToTask(taskDto);
        taskDto.setDueDate(new Date());
        taskN.setId(id);
        taskService.update(taskN, id);
        return new ResponseEntity<>(taskDto,HttpStatus.ACCEPTED);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        //TODO implement this method using UserService
        return new ResponseEntity<>(taskService.deleteById(id), HttpStatus.ACCEPTED);
    }




    public TaskDto convertToTaskDto(Task taskC){

        TaskDto taskDto = new TaskDto();
        taskDto.setName(taskC.getName());
        taskDto.setDescriptiom(taskC.getDescriptiom());
        taskDto.setStatus(taskC.getStatus());
        taskDto.setAssignedTo(taskC.getAssignedTo());
        taskDto.setDueDate(taskC.getDueDate());
        taskDto.setCreatedAt(taskC.getCreatedAt());

        return taskDto;
    }
    public Task convertToTask(TaskDto taskDto){
        Task task = new Task();
        task.setId(valueOf(Math.random()));
        task.setName(taskDto.getName());
        task.setDescriptiom(taskDto.getDescriptiom());
        task.setStatus(taskDto.getStatus());
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setDueDate(taskDto.getDueDate());
        task.setCreatedAt(taskDto.getCreatedAt());
        return task;
    }


}
