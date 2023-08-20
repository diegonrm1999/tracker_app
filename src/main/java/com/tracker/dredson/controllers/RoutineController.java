package com.tracker.dredson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dredson.models.Routine;
import com.tracker.dredson.services.RoutineService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/routine")
@RequiredArgsConstructor
@RestController
public class RoutineController {
    @Autowired
    RoutineService routineService;

    @GetMapping("")
    public List<Routine> getAllRoutinesByDate() {
        return routineService.getAllRoutinesByDate();
    }

    @PostMapping("")
    public Routine saveRoutine(@RequestBody Routine routine) throws Exception {
        return routineService.saveRoutine(routine);
    }
}
