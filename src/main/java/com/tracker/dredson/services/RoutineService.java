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

import com.tracker.dredson.Authentication.IAuthenticationFacade;
import com.tracker.dredson.models.Exercise;
import com.tracker.dredson.models.Routine;
import com.tracker.dredson.models.User;
import com.tracker.dredson.models.common.ExceptionResponse;
import com.tracker.dredson.repositories.ExerciseRepository;
import com.tracker.dredson.repositories.RoutineRepository;
import com.tracker.dredson.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;
    private final IAuthenticationFacade authenticationFacade;
    private final UserRepository userRepository;


    public List<Routine> getAllRoutinesByDate(long timestamp) {

        String username = authenticationFacade.getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.systemDefault(); 
        ZonedDateTime startDate = instant.atZone(zoneId);
        ZonedDateTime endDate = startDate.plusDays(1);

        Long startOfDayMillis = startDate.toInstant().toEpochMilli();
        Long endOfDayMillis = endDate.toInstant().toEpochMilli();

        return routineRepository.findByTimestampBetweenAndUserId(startOfDayMillis, endOfDayMillis, user.getId());
    }

    public Routine saveRoutine(Routine routine) throws Exception {
        String username = authenticationFacade.getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        if (routine.getExerciseId() == null) {
            throw new Exception("Exercise ID is empty");
        }
        Optional<Exercise> exercise = exerciseRepository.findById(routine.getExerciseId());
        if (exercise.isPresent()) {
            routine.setExerciseName(exercise.get().getName());
        }
        routine.setUserId(user.getId());
        return routineRepository.save(routine);
    }
}
