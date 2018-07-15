package com.example.taskapi.service;

import java.util.List;
import com.example.taskapi.domain.Task;

public interface TaskService {

  List<Task> findAll();

  List<Task> findByUsername(String username);

  Task create(Task resource);
}
