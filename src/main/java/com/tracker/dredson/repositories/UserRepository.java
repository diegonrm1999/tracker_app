package com.tracker.dredson.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.dredson.models.User;

public interface UserRepository extends MongoRepository<User, String>{
    
}
