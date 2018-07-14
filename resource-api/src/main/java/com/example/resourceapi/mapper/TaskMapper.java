package com.example.resourceapi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.resourceapi.domain.Task;

@Mapper
public interface TaskMapper {

  List<Task> findAll();

  List<Task> findByUsrname(String usrname);

  void insert(Task resource);

}
