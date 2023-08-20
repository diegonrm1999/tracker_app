package com.tracker.dredson.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tracker.dredson.models.common.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "routines")
@Getter
@Setter
public class Routine extends BaseModel {
    private String exerciseId;
    private Exercise exercise;
    private String exerciseName;
    private Long dateScheduled;
    private String userId;
    private int lastRep = 0;
    private int lastWeight = 0;
}
