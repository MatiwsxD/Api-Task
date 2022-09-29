package eci.edu.escuelaing.Task.entities;

import eci.edu.escuelaing.Task.enums.Status;

import java.util.Date;

public class Task {


    Status Status;
    String name;
    String descriptiom;
    String id;
    String assignedTo;
    Date dueDate;
    String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public eci.edu.escuelaing.Task.enums.Status getStatus() {
        return Status;
    }

    public void setStatus(eci.edu.escuelaing.Task.enums.Status status) {
        Status = status;
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
