package com.tracker.dredson.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tracker.dredson.models.TrackerRoutine;

public interface TrackerRoutineRepository extends MongoRepository<TrackerRoutine, String> {
    @Query("{'routineId' : :#{#routineId}}")
    public List<TrackerRoutine> findByRoutineId(@Param("routineId") String routineId);
    
}
