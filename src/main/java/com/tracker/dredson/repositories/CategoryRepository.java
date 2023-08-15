package com.tracker.dredson.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.dredson.models.Category;


public interface CategoryRepository extends MongoRepository<Category, String> {
}