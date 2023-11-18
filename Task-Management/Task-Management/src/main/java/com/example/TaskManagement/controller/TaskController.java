package com.example.TaskManagement.controller;

import com.example.TaskManagement.dto.TaskRequest;
import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public String createTask(@RequestBody TaskRequest taskRequest)
    {
        taskService.CreateTask(taskRequest);
        return "Task Created";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Task>> getAllTask()
    {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/get")
    public ResponseEntity<Task>getTask(@RequestParam("id") String id)
    {
        return ResponseEntity.ok(taskService.getTask(id));
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTask(String id)
    {
        taskService.deleteTask(id);
        return "Deleted";
    }
}
