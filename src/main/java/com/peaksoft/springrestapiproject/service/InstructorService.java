
package com.peaksoft.springrestapiproject.service;

import com.peaksoft.springrestapiproject.dto.request.InstructorRequest;
import com.peaksoft.springrestapiproject.dto.responce.InstructorResponse;

import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getInstructorList();
    List<InstructorResponse> getAlInstructors(Long courseId);

    InstructorResponse addInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    InstructorResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse deleteInstructor(Long id);

    void assignInstructor(Long courseId,Long instructorId) throws IOException;
}