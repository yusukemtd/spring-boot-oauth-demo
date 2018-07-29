package com.example.taskclient.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

  public String taskId;
  
  public String task;

  public String username;

  public Date createdAt;

}
