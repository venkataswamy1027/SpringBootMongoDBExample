package com.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "tutorials")
public class Tutorial {
  @Id
  private String id;
  private String title;
  private String description;
  private boolean published;

}
