package com.example.taskapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.taskapi.domain.Task;
import com.example.taskapi.service.TaskService;

@RestController
public class TaskController {

  @Autowired
  TaskService taskService;
 
  @GetMapping("v1/timelines")
  List<Task> getTimelines() {
    return taskService.findAll();
  }

  @GetMapping("v1/tasks")
  List<Task> getResourcesByUser(Authentication authentication) {
    String username = authentication.getName();
    return taskService.findByUsername(username);
  }

  @PostMapping("v1/task")
  Task postResource(@RequestBody Task task, Authentication authentication) {
    task.username = authentication.getName();
    return taskService.create(task);
  }
}
