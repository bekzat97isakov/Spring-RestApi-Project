package com.peaksoft.springrestapiproject.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class CourseResponse {
    private Long id;
    private String courseName;
    private int duration;
    private String description;
}
