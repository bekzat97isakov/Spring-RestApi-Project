package com.peaksoft.springrestapiproject.service;

import com.peaksoft.springrestapiproject.dto.request.CourseRequest;
import com.peaksoft.springrestapiproject.dto.responce.CourseResponse;
import com.peaksoft.springrestapiproject.entities.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses(Long id);

    CourseResponse addCourse(Long id, CourseRequest course);

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    CourseResponse deleteCourse(Long id);
}
