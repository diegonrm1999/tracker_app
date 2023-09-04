package com.tracker.dredson.models.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRegisterRequest {
    String username;
    String password;
    String firstName;
    String lastName;
    String country; 
}
