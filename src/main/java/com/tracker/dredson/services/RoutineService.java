package com.tracker.dredson.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dredson.models.Exercise;
import com.tracker.dredson.models.Routine;
import com.tracker.dredson.repositories.ExerciseRepository;
import com.tracker.dredson.repositories.RoutineRepository;

@Service
public class RoutineService {
    @Autowired
    RoutineRepository routineRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Routine> getAllRoutinesByDate(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.systemDefault(); 
        ZonedDateTime startDate = instant.atZone(zoneId);
        ZonedDateTime endDate = startDate.plusDays(1);

        Long startOfDayMillis = startDate.toInstant().toEpochMilli();
        Long endOfDayMillis = endDate.toInstant().toEpochMilli();

        return routineRepository.findByTimestampBetween(startOfDayMillis, endOfDayMillis);
    }

    public Routine saveRoutine(Routine routine) throws Exception {
        if (routine.getExerciseId() == null) {
            throw new Exception("Exercise ID is empty");
        }
        Optional<Exercise> exercise = exerciseRepository.findById(routine.getExerciseId());
        if (exercise.isPresent()) {
            routine.setExerciseName(exercise.get().getName());
        }
        return routineRepository.save(routine);
    }
}
