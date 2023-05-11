package com.example.springrest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PeopleErrorResponse {
    private String message;
    private long timestamp;
}
