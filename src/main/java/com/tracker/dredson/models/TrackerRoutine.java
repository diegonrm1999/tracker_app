package com.tracker.dredson.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tracker.dredson.models.common.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "tracker_routine")
@Getter
@Setter
public class TrackerRoutine extends BaseModel {
    private int rep;
    private double weight;
    private String routineId;
}
