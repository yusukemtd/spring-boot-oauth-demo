package com.example.taskapi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.taskapi.domain.Task;

@Mapper
public interface TaskMapper {

  List<Task> findAll();

  List<Task> findByUsername(String username);

  void insert(Task resource);

}
