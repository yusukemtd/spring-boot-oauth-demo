package com.example.resourceapi.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {

  public String resourceId;
  
  public String msg;

  public String username;

  public Date createdAt;

}
