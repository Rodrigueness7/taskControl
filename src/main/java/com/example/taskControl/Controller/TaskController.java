package com.example.taskControl.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.taskControl.Model.Task;
import com.example.taskControl.Service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/task")
public class TaskController {
    
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/findAllTask")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> task = taskService.getAllTasks();

        return ResponseEntity.ok(task);
    }

    @GetMapping("/findTask/{id}")
    public ResponseEntity<Task>getTask(@PathVariable Long id) {
       Optional<Task> task = taskService.getTask(id);
       return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTask); 
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, Task task) {
        Optional<Task> findTask = taskService.getTask(id);
        if(findTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task updateTask = taskService.updateTask(id, task);
    
        return ResponseEntity.ok(updateTask);
        
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    } 
   
    
    
    
}
