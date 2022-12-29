package com.rest.collection;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "image")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {

	@Id
	private String id;
	private String title;
	private Binary image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	
	
}
