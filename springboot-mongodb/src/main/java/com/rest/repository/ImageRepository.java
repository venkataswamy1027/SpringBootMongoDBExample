package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.collection.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

}
