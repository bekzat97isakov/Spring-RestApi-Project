
package com.peaksoft.springrestapiproject.service.Impl;

import com.peaksoft.springrestapiproject.converter.course.CourseRequestConverter;
import com.peaksoft.springrestapiproject.converter.course.CourseResponseConverter;
import com.peaksoft.springrestapiproject.dto.request.CourseRequest;
import com.peaksoft.springrestapiproject.dto.responce.CourseResponse;
import com.peaksoft.springrestapiproject.entities.Company;
import com.peaksoft.springrestapiproject.entities.Course;
import com.peaksoft.springrestapiproject.repository.CompanyRepository;
import com.peaksoft.springrestapiproject.repository.CourseRepository;
import com.peaksoft.springrestapiproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseResponseConverter courseResponseConverter;
    private final CourseRequestConverter courseRequestConverter;


    @Override
    public List<CourseResponse> getAllCourses(Long id) {
        return courseResponseConverter.view(courseRepository.getAllCourses(id));
    }

    @Override
    public CourseResponse addCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRequestConverter.createCourse(courseRequest);
        Company company = companyRepository.getById(id);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest)  {
        Course course = courseRepository.findById(id).get();
        courseRequestConverter.updateCourse(course, courseRequest);
        courseRepository.save(course);

        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        courseRepository.delete(course);
        return courseResponseConverter.viewCourse(course);
    }

}