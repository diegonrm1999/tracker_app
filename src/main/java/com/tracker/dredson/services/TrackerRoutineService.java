package com.tracker.dredson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dredson.models.TrackerRoutine;
import com.tracker.dredson.repositories.TrackerRoutineRepository;

@Service
public class TrackerRoutineService {
    @Autowired
    TrackerRoutineRepository trackerRepository;

    public TrackerRoutine saveTrackerRoutine(TrackerRoutine trackerRoutine) {
        return trackerRepository.save(trackerRoutine);
    }

    public List<TrackerRoutine> getAllTracksByRoutineId(String routineId) {
        return trackerRepository.findByRoutineId(routineId);
    }
    
}
