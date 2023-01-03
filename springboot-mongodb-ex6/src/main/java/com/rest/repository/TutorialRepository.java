package com.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Tutorial;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
	
	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByPublished(boolean published);
}
