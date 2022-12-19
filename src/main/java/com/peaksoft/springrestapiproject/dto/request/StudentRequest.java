package com.peaksoft.springrestapiproject.dto.request;

import com.peaksoft.springrestapiproject.entities.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private StudyFormat studyFormat;
}
