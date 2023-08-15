package com.tracker.dredson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dredson.models.Exercise;
import com.tracker.dredson.services.ExerciseService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
@Controller
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;

    @GetMapping("")
    public List<Exercise> getExercises() {
        return exerciseService.getAll();
    }
    
    @GetMapping("/category/{categoryId}")
    public List<Exercise> getByCategory(@PathParam("categoryId") String categoryId) {
        return exerciseService.getByCategory(categoryId);
    }
}
