
package com.peaksoft.springrestapiproject.converter.instructor;

import com.peaksoft.springrestapiproject.dto.responce.InstructorResponse;
import com.peaksoft.springrestapiproject.entities.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorResponseConverter {
    public InstructorResponse viewInstructor(Instructor instructor) {
        if (instructor == null) {
            return null;
        }
        InstructorResponse instructorResponse = new InstructorResponse();

        instructorResponse.setId(instructor.getId());
        instructorResponse.setLastName(instructor.getLastName());
        instructorResponse.setFirstName(instructor.getFirstName());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setSpecialization(instructor.getSpecialization());
        return instructorResponse;
    }

    public List<InstructorResponse> view(List<Instructor> instructors) {
        List<InstructorResponse> instructorResponseList = new ArrayList<>();
        for (Instructor instructor : instructors) {
            instructorResponseList.add(viewInstructor(instructor));
        }
        return instructorResponseList;
    }
}
