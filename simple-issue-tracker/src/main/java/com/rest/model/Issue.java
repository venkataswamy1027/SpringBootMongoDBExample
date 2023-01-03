package com.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "issues")
public class Issue {

	@Id
	private String id;
	private String description;
	private int severity;
	private String assignee;
}
