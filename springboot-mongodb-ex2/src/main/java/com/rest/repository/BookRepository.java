package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
