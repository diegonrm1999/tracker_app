package com.tracker.dredson.models;

import com.tracker.dredson.models.common.BaseModel;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User extends BaseModel {
    private String email;
    private String password;
    private String firstName;
    private String LastName;
}
