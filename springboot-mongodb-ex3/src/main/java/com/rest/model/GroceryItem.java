package com.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document
@JsonInclude (JsonInclude.Include.NON_NULL)
public class GroceryItem {

	@Id
	private String id;

	private String name;
	private int quantity;
	private String category;
}