package eci.edu.escuelaing.Task.impl;

import eci.edu.escuelaing.Task.dto.TaskDto;
import eci.edu.escuelaing.Task.entities.Task;
import eci.edu.escuelaing.Task.repository.TaskRepository;
import eci.edu.escuelaing.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceMongoDB implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceMongoDB(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e){
            new Exception("La tarea con id: " + id + "no existe", e);
            return false;
        }
    }

    @Override
    public Task update(Task task, String id) {
        Task updateTask = findById(id);
        updateTask.setName(task.getName());
        updateTask.setDescriptiom(task.getDescriptiom());
        updateTask.setStatus(task.getStatus());
        updateTask.setAssignedTo(task.getAssignedTo());
        updateTask.setDueDate(task.getDueDate());
        return create(updateTask);
    }

    @Override
    public TaskDto mapToDto(Task task) {
        TaskDto taskDTO = new TaskDto();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setDescriptiom(task.getDescriptiom());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setAssignedTo(task.getAssignedTo());
        taskDTO.setCreatedAt(task.getCreatedAt());
        taskDTO.setDueDate(task.getDueDate());
        return taskDTO;
    }

    @Override
    public Task mapToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setDescriptiom(taskDto.getDescriptiom());
        task.setStatus(taskDto.getStatus());
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setCreatedAt(taskDto.getCreatedAt());
        task.setDueDate(taskDto.getDueDate());
        return task;
    }
}