package com.peaksoft.springrestapiproject.converter.student;

import com.peaksoft.springrestapiproject.dto.request.StudentRequest;
import com.peaksoft.springrestapiproject.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestConverter {
    public Student createStudent(StudentRequest studentRequest){
        if (studentRequest==null){
            return null;
        }
        Student student = new Student();
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setEmail(student.getEmail());
        student.setPhoneNumber(student.getPhoneNumber());
        student.setStudyFormat(student.getStudyFormat());
        return student;
    }
    public void updateStudent(StudentRequest studentRequest,Student student){
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setPhoneNumber(student.getPhoneNumber());
        student.setEmail(student.getEmail());
        student.setStudyFormat(student.getStudyFormat());
    }
}
