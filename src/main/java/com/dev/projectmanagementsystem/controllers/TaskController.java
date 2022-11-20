package com.dev.projectmanagementsystem.controllers;

import com.dev.projectmanagementsystem.models.Task;
import com.dev.projectmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
       return taskRepository.save(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTopTasks() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate.setName(task.getName());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setDeadline(task.getDeadline());
        return ResponseEntity.ok(taskRepository.save(taskToUpdate));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
