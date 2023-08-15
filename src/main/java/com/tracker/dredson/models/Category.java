package com.tracker.dredson.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tracker.dredson.models.common.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Category")
@Getter
@Setter
public class Category extends BaseModel {
    public enum CategoryType {
        Triceps,
        Biceps,
        Back,
        Chest,
        Shoulders,
        Quadriceps,
        Hamstring,
        Calf,
        Glutes
    }
    private CategoryType name;
}
