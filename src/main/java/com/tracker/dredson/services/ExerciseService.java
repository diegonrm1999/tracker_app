package com.tracker.dredson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dredson.models.Category;
import com.tracker.dredson.models.Exercise;
import com.tracker.dredson.repositories.CategoryRepository;
import com.tracker.dredson.repositories.ExerciseRepository;

@Service
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getByCategory(String categoryId) {
        return exerciseRepository.findByCategoryId(categoryId);
    }

    public Exercise saveExercise(Exercise exercise) {
        Optional<Category> category = categoryRepository.findById(exercise.getCategoryId());
        if (category.isPresent()) {
            exercise.setCategoryName(category.get().getName().name());
        }
        return exerciseRepository.save(exercise);
    }
}
