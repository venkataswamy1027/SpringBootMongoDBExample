package com.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "domain")
public class Domain {

	@Id
	private long id;

	@Indexed(unique = true)
	private String domain;

	private boolean displayAds;
}
