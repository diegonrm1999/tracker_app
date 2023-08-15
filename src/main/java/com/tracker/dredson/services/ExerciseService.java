package com.tracker.dredson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tracker.dredson.models.Exercise;
import com.tracker.dredson.repositories.ExerciseRepository;

public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getByCategory(String categoryId) {
        return exerciseRepository.findByCategoryId(categoryId);
    }
}
