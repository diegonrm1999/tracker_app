package com.tracker.dredson.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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

    public List<Routine> getAllRoutinesByDate() {
        ZonedDateTime today = ZonedDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT, ZoneId.systemDefault());
        ZonedDateTime tomorrow = today.plusDays(1);
        Long startOfDayMillis = today.toInstant().toEpochMilli();
        Long endOfDayMillis = tomorrow.toInstant().toEpochMilli();

        return routineRepository.findByTimestampBetween(startOfDayMillis, endOfDayMillis);
    }

    public Routine saveRoutine(Routine routine) throws Exception {
        if (routine.getExerciseId() == null) {
            throw new Exception("Exercise ID is empty");
        }
        Optional<Exercise> exercise = exerciseRepository.findById(routine.getExerciseId());
        Long currentTimestamp = Instant.now().toEpochMilli();
        routine.setDateScheduled(currentTimestamp);
        if (exercise.isPresent()) {
            routine.setExerciseName(exercise.get().getName());
        }
        return routineRepository.save(routine);
    }
}
