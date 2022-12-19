
package com.peaksoft.springrestapiproject.controller;

import com.peaksoft.springrestapiproject.dto.request.StudentRequest;
import com.peaksoft.springrestapiproject.dto.responce.StudentResponse;
import com.peaksoft.springrestapiproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentResponse> getAllInstructor(){
        return  studentService.getStudentList();
    }

    @GetMapping("/getAllByGroupId/{groupId}")
    public List<StudentResponse> getAllStudent(@PathVariable Long groupId){
        return studentService.getAllStudents(groupId);
    }

    @PostMapping("/save/{id}")
    public StudentResponse saveStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.addStudent(id, studentRequest);
    }

    @GetMapping("/findById/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public StudentResponse deleteById(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable Long id) throws IOException {
        return studentService.updateStudent( studentRequest,id);
    }

    @PostMapping("/assignStudent/{studentId}/{groupId}")
    public void assignStudent(@PathVariable("studentId")Long studentId, @PathVariable("groupId") Long groupId) throws IOException {
        studentService.assignStudent(groupId, studentId);
    }
}
