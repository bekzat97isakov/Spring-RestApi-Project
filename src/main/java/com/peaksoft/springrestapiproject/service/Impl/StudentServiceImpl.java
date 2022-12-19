
package com.peaksoft.springrestapiproject.service.Impl;

import com.peaksoft.springrestapiproject.converter.student.StudentRequestConverter;
import com.peaksoft.springrestapiproject.converter.student.StudentResponseConverter;
import com.peaksoft.springrestapiproject.dto.request.StudentRequest;
import com.peaksoft.springrestapiproject.dto.responce.StudentResponse;
import com.peaksoft.springrestapiproject.entities.Course;
import com.peaksoft.springrestapiproject.entities.Group;
import com.peaksoft.springrestapiproject.entities.Student;
import com.peaksoft.springrestapiproject.repository.GroupRepository;
import com.peaksoft.springrestapiproject.repository.StudentRepository;
import com.peaksoft.springrestapiproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentRequestConverter studentRequestConverter;
    private final StudentResponseConverter studentResponseConverter;

    @Override
    public List<StudentResponse> getStudentList() {
        return studentResponseConverter.view(studentRepository.findAll());
    }

    @Override
    public List<StudentResponse> getAllStudents(Long id) {
        return studentResponseConverter.view(studentRepository.findAllStudentByGroupId(id));
    }

    @Override
    public StudentResponse addStudent(Long id, StudentRequest studentRequest) throws IOException {
        List<Student> students = studentRepository.findAll();
        for (Student i : students) {
            if (i.getEmail().equals(studentRequest.getEmail())) {
                throw new IOException("Student with email already exists!");
            }
        }
        Student student = studentRequestConverter.createStudent(studentRequest);

        Group group = groupRepository.getById( id);
        group.addStudent(student);
        student.setGroup(group);


        return studentResponseConverter.viewStudent(student);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentResponseConverter.viewStudent(studentRepository.getById(id));
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long id) {
        Student student1 = studentRepository.getById(id);
        studentRequestConverter.updateStudent(studentRequest,student1);
        studentRepository.save(student1);
        return studentResponseConverter.viewStudent(student1);
    }

    @Override

    public StudentResponse deleteStudent(Long id) {
        Student student = studentRepository.getById(id);
        for (Course c:student.getGroup().getCourseList()) {
            c.getCompany().kemuuStudent();
        }
        studentRepository.delete(student);
        return studentResponseConverter.viewStudent(student);
    }

    @Override
    public void assignStudent(Long groupId, Long studentId) throws IOException {
        Student student = studentRepository.getById(studentId);
        Group group = groupRepository.getById(groupId);

        if (group.getStudentList()!=null){
            for (Student g : group.getStudentList()) {
                if (g.getId() == studentId) {
                    throw new IOException("This student already exists!");
                }
            }
        }

        student.getGroup().getStudentList().remove(student);
        group.addStudent(student);
        student.setGroup(group);
        studentRepository.save(student);
        groupRepository.save(group);
    }
}