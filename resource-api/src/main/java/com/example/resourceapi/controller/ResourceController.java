package com.example.resourceapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.resourceapi.domain.Resource;
import com.example.resourceapi.service.ResourceService;

@RestController
public class ResourceController {

  @Autowired
  ResourceService resourceService;
 
  @GetMapping("v1/resources")
  List<Resource> getResoruce() {
    return resourceService.findAll();
  }

  @GetMapping("v1/resource")
  List<Resource> getResourcesByUser(Authentication authentication) {
    String username = authentication.getName();
    return resourceService.findByUsername(username);
  }

  @PostMapping("v1/resource")
  Resource postResource(@RequestBody Resource resource, Authentication authentication) {
    resource.username = authentication.getName();
    return resourceService.create(resource);
  }
}
