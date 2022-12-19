
package com.peaksoft.springrestapiproject.controller;

import com.peaksoft.springrestapiproject.dto.request.InstructorRequest;
import com.peaksoft.springrestapiproject.dto.responce.InstructorResponse;
import com.peaksoft.springrestapiproject.entities.Instructor;
import com.peaksoft.springrestapiproject.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/getAll")
    public List<InstructorResponse> getAllInstructor(){
        return instructorService.getInstructorList();
    }

    @GetMapping("/getAllByCourseId/{courseId}")
    public List<InstructorResponse> getAllInstructor(@PathVariable Long courseId){
        return instructorService.getAlInstructors(courseId);
    }

    @PostMapping("/save/{id}")
    public InstructorResponse saveInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.addInstructor(id, instructorRequest);
    }

    @GetMapping("/findById/{id}")
    public InstructorResponse findById(@PathVariable Long id){
        return instructorService.getInstructorById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public InstructorResponse deleteById(@PathVariable Long id){
        return instructorService.deleteInstructor(id);
    }

    @PutMapping("/update/{id}")
    public InstructorResponse updateInstructor(@RequestBody InstructorRequest instructorRequest, @PathVariable Instructor id) throws IOException {
        return instructorService.updateInstructor(id.getId(), instructorRequest);
    }

    @PostMapping("/assignInstructor/{instructorId}/{courseId}")
    public void assignInstructor(@PathVariable("instructorId")Long instructorId, @PathVariable("courseId") Long courseId) throws IOException {
        instructorService.assignInstructor(courseId, instructorId);
    }
}
