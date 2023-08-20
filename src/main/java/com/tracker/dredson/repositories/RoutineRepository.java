package com.tracker.dredson.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tracker.dredson.models.Routine;

public interface RoutineRepository extends MongoRepository<Routine, String> {
    @Query("{ 'dateScheduled' : { $gte: ?0, $lt: ?1 } }")
    List<Routine> findByTimestampBetween(long startOfDay, long endOfDay);

}
