package com.example.resourceapi.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.resourceapi.domain.Resource;
import com.example.resourceapi.mapper.ResourceMapper;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

  @Autowired
  ResourceMapper resourceMapper;

  @Override
  public List<Resource> findAll() {
    return resourceMapper.findAll();
  }

  @Override
  public List<Resource> findByUsername(String username) {
    return resourceMapper.findByUsrname(username);
  }

  @Override
  public Resource create(Resource resource) {

    resource.resourceId = UUID.randomUUID().toString();
    resource.createdAt = new Date();
    resourceMapper.insert(resource);
    return resource;
  }

}
