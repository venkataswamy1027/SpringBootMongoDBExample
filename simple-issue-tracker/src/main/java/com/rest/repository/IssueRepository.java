package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Issue;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {

}
