package com.example.resourceapi.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.resourceapi.domain.Task;
import com.example.resourceapi.mapper.TaskMapper;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

  @Autowired
  TaskMapper taskMapper;

  @Override
  public List<Task> findAll() {
    return taskMapper.findAll();
  }

  @Override
  public List<Task> findByUsername(String username) {
    return taskMapper.findByUsername(username);
  }

  @Override
  public Task create(Task task) {

    task.taskId = UUID.randomUUID().toString();
    task.createdAt = new Date();
    taskMapper.insert(task);
    return task;
  }

}
