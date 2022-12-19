
package com.peaksoft.springrestapiproject.service;

import com.peaksoft.springrestapiproject.dto.request.StudentRequest;
import com.peaksoft.springrestapiproject.dto.responce.StudentResponse;
import com.peaksoft.springrestapiproject.entities.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudentList();

    List<StudentResponse> getAllStudents(Long groupId);

    StudentResponse addStudent(Long id, StudentRequest student) throws IOException;

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(StudentRequest student, Long id);

    StudentResponse deleteStudent(Long id);

    void assignStudent(Long groupId,Long studentId) throws IOException;
}
