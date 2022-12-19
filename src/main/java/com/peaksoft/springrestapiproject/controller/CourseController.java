
package com.peaksoft.springrestapiproject.controller;

import com.peaksoft.springrestapiproject.dto.request.CourseRequest;
import com.peaksoft.springrestapiproject.dto.responce.CourseResponse;
import com.peaksoft.springrestapiproject.entities.Course;
import com.peaksoft.springrestapiproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/getAll/{id}")
    public List<CourseResponse> getAllCourse(@PathVariable Long id){
        return courseService.getAllCourses(id);
    }

    @PostMapping("/save/{id}")
    public CourseResponse saveCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest)  {
        return courseService.addCourse(id, courseRequest);
    }

    @GetMapping("/findById/{id}")
    public CourseResponse findById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public CourseResponse deleteById(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

    @PutMapping("/update/{id}")
    public CourseResponse updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Course id)  {
        return courseService.updateCourse(id.getId(), courseRequest);
    }
}
