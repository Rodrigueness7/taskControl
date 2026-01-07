package com.example.taskControl.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taskControl.Model.Task;
import com.example.taskControl.Repository.TaskRepository;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updateTask) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if(!existingTask.isPresent()) {
            throw new RuntimeException("Task not found");
        }

        Task task = existingTask.get();
        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setStatus(updateTask.getStatus());
        task.setUser(updateTask.getUser());
        task.setCreatedAt(updateTask.getCreatedAt());
        return taskRepository.save(task);

    }

    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}
