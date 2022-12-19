package com.peaksoft.springrestapiproject.dto.responce;

import com.peaksoft.springrestapiproject.entities.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private StudyFormat studyFormat;
}
