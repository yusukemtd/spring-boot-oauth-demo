package com.example.taskclient.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.taskclient.domain.Task;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TaskController {

  private final RestTemplate restTemplate;
  private final URI taskApiUri;

  public TaskController(RestTemplate restTemplate, @Value("${task.api.uri}") URI taskApiUri) {
    this.restTemplate = restTemplate;
    this.taskApiUri = taskApiUri;

    log.debug("taskApiUri: {}", taskApiUri.toString());
  }

  @GetMapping("/")
  String timelines(Model model) {
    URI uri = UriComponentsBuilder.fromUri(taskApiUri).pathSegment("timelines").build().toUri();
    RequestEntity<?> request = RequestEntity.get(uri).build();

    log.debug("call timeline API: {}", uri.toString());

    List<Task> tasks =
        restTemplate.exchange(request, new ParameterizedTypeReference<List<Task>>() {}).getBody();
    model.addAttribute("tasks", tasks);
    return "tasks";
  }

  @GetMapping("/tasks")
  String tasks(Model model) {
    URI uri = UriComponentsBuilder.fromUri(taskApiUri).pathSegment("tasks").build().toUri();
    RequestEntity<?> request = RequestEntity.get(uri).build();

    log.debug("call tasks API: {}", uri.toString());

    List<Task> tasks =
        restTemplate.exchange(request, new ParameterizedTypeReference<List<Task>>() {}).getBody();
    model.addAttribute("tasks", tasks);
    return "tasks";
  }

  @PostMapping("/task")
  String tasks(@RequestParam String task) {
    URI uri = UriComponentsBuilder.fromUri(taskApiUri).pathSegment("task").build().toUri();

    log.debug("call task API: {}, Task: {}", uri.toString(), task);

    RequestEntity<?> request = RequestEntity.post(uri).body(Collections.singletonMap("task", task));
    restTemplate.exchange(request, Void.class);
    return "redirect:/";
  }
}
