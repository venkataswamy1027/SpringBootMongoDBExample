package com.rest.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rest.collection.Image;
import com.rest.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	public Image addImage(String originalFilename, MultipartFile image) throws IOException {
		Image photo = new Image();
		photo.setTitle(originalFilename);
		photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		return imageRepository.save(photo);
	}

	public Image getImageById(String id) {
		return imageRepository.findById(id).get();
	}

}
