package com.example.resourceapi.service;

import java.util.List;
import com.example.resourceapi.domain.Task;

public interface TaskService {

  List<Task> findAll();

  List<Task> findByUsername(String username);

  Task create(Task resource);
}
