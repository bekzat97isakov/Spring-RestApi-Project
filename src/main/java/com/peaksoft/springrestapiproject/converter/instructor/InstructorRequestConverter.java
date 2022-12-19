
package com.peaksoft.springrestapiproject.converter.instructor;

import com.peaksoft.springrestapiproject.dto.request.InstructorRequest;
import com.peaksoft.springrestapiproject.entities.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorRequestConverter {
    public Instructor createInstructor(InstructorRequest instructorRequest) {
        if (instructorRequest == null) {
            return null;
        }
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        return instructor;
    }

    public void updateInstructor(Instructor instructor, InstructorRequest instructorRequest) {
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setSpecialization(instructorRequest.getSpecialization());
    }
}
