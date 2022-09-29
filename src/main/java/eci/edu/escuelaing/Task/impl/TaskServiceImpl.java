package eci.edu.escuelaing.Task.impl;

import eci.edu.escuelaing.Task.dto.TaskDto;
import eci.edu.escuelaing.Task.entities.Task;
import eci.edu.escuelaing.Task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private HashMap<String, Task> tasks = new HashMap<String, Task>();

    @Override
    public Task create(Task task) {
        tasks.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<Task>(tasks.values());
    }

    @Override
    public boolean deleteById(String id) {
        boolean flag = false;
        try{
            tasks.remove(id);
            flag = true;
        }
        catch (Exception e){
            flag = false;
        }

        return flag;
    }

    @Override
    public Task update(Task task, String taskId) {
        tasks.replace(taskId,task);
        return task;
    }
    @Override
    public TaskDto mapToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescriptiom(task.getDescriptiom());
        taskDto.setStatus(task.getStatus());
        taskDto.setAssignedTo(task.getAssignedTo());
        taskDto.setDueDate(task.getDueDate());
        taskDto.setCreatedAt(task.getCreatedAt());
        return taskDto;
    }

    @Override
    public Task mapToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setDescriptiom(taskDto.getDescriptiom());
        task.setStatus(taskDto.getStatus());
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setDueDate(taskDto.getDueDate());
        task.setCreatedAt(taskDto.getCreatedAt());
        return task;
    }

}
