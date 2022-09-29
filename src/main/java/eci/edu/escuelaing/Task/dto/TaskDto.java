package eci.edu.escuelaing.Task.dto;

import eci.edu.escuelaing.Task.enums.Status;

import java.util.Date;

public class TaskDto {


    String name;
    String descriptiom;
    String Id;
    Status status;
    String assignedTo;
    Date dueDate;
    String createdAt;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptiom() {
        return descriptiom;
    }

    public void setDescriptiom(String descriptiom) {
        this.descriptiom = descriptiom;
    }


    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
