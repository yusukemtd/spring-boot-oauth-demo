package com.example.resourceapi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.resourceapi.domain.Resource;

@Mapper
public interface ResourceMapper {

  List<Resource> findAll();

  List<Resource> findByUsrname(String usrname);

  void insert(Resource resource);

}
