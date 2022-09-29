package eci.edu.escuelaing.Task.service;

import eci.edu.escuelaing.Task.dto.TaskDto;
import eci.edu.escuelaing.Task.entities.Task;

import java.util.List;

public interface TaskService
{
    Task create(Task task );

    Task findById( String id );

    List<Task> getAll();

    boolean deleteById( String id );

    Task update( Task task, String id );
    TaskDto mapToDto(Task task);
    Task mapToEntity(TaskDto taskDto);
}