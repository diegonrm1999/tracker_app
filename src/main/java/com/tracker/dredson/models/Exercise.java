package com.tracker.dredson.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.tracker.dredson.models.common.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "exercises")
@Getter
@Setter
public class Exercise extends BaseModel {
    private String name;
    private String categoryId;
    private String imageUrl;
    private String description;
}
