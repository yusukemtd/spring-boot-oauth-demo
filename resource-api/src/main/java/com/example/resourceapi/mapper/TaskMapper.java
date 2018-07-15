package com.example.resourceapi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.resourceapi.domain.Task;

@Mapper
public interface TaskMapper {

  List<Task> findAll();

  List<Task> findByUsername(String username);

  void insert(Task resource);

}
