package com.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Customer {

	  @Id
	  public String id;
	  public String firstName;
	  public String lastName;
}
