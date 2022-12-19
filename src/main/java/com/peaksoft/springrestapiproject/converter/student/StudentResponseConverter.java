package com.peaksoft.springrestapiproject.converter.student;

import com.peaksoft.springrestapiproject.dto.responce.StudentResponse;
import com.peaksoft.springrestapiproject.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseConverter {
    public StudentResponse viewStudent(Student student){
        if (student==null){
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getFirstName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setPhoneNumber(student.getPhoneNumber());
        studentResponse.setStudyFormat(student.getStudyFormat());
        return studentResponse;
    }
    public List<StudentResponse> view(List<Student>students){
        List<StudentResponse>studentResponseList = new ArrayList<>();
        for (Student student: students){
            studentResponseList.add(viewStudent(student));
        }
        return studentResponseList;
    }
}
