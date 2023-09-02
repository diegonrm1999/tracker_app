package com.tracker.dredson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dredson.models.TrackerRoutine;
import com.tracker.dredson.services.TrackerRoutineService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/tracker")
@RestController
public class TrackerRoutineController {
    @Autowired
    TrackerRoutineService trackerRoutineService;

    @PostMapping("")
    public TrackerRoutine save(@RequestBody TrackerRoutine trackerRoutine) {
        return trackerRoutineService.saveTrackerRoutine(trackerRoutine);
    }

    @GetMapping("/{routineId}")
    public List<TrackerRoutine> getAllTracksByRoutineId(@PathVariable String routineId) {
        return trackerRoutineService.getAllTracksByRoutineId(routineId);
    }
}
