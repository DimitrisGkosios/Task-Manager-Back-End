package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Παίρνουμε τον logged-in χρήστη από το security context
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getUserTasks(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = userDetails.getUser().getId();
        List<TaskDTO> tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@AuthenticationPrincipal CustomUserDetails userDetails,
                                              @RequestBody TaskDTO taskDTO) {
        Long userId = userDetails.getUser().getId();
        TaskDTO created = taskService.createTask(userId, taskDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@AuthenticationPrincipal CustomUserDetails userDetails,
                                              @PathVariable Long id,
                                              @RequestBody TaskDTO taskDTO) {
        Long userId = userDetails.getUser().getId();
        TaskDTO updated = taskService.updateTask(userId, id, taskDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@AuthenticationPrincipal CustomUserDetails userDetails,
                                           @PathVariable Long id) {
        Long userId = userDetails.getUser().getId();
        taskService.deleteTask(userId, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@AuthenticationPrincipal CustomUserDetails userDetails,
                                               @PathVariable Long id) {
        Long userId = userDetails.getUser().getId();

        TaskDTO task = taskService.getTaskById(userId, id);
        return ResponseEntity.ok(task);
    }
}
