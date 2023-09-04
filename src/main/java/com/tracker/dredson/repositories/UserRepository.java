package com.tracker.dredson.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tracker.dredson.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'username' : :#{#username}}")
    public Optional<User> findByUsername(@Param("username") String username);
}
