package com.tracker.dredson.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tracker.dredson.models.Exercise;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {
    @Query("{'categoryId' : :#{#categoryId}}")
    List<Exercise> findByCategoryId(@Param("categoryId") String categoryId);
}
