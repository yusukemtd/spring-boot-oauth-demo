package com.example.resourceapi.service;

import java.util.List;
import com.example.resourceapi.domain.Resource;

public interface ResourceService {

  List<Resource> findAll();

  List<Resource> findByUsername(String username);

  Resource create(Resource resource);
}
