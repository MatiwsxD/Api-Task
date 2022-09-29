package eci.edu.escuelaing.Task.repository;



import eci.edu.escuelaing.Task.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}