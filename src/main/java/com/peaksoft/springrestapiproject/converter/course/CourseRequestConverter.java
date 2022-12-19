package com.peaksoft.springrestapiproject.converter.course;


import com.peaksoft.springrestapiproject.dto.request.CourseRequest;
import com.peaksoft.springrestapiproject.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseRequestConverter {
    public Course createCourse(CourseRequest courseRequest){
        if (courseRequest == null){
            return null;
        }

        Course course = new Course();

        course.setCourseName(courseRequest.getCourseName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());

        return course;
    }


    public void updateCourse(Course course, CourseRequest courseRequest){
        if (courseRequest.getCourseName() != null){
            course.setCourseName(courseRequest.getCourseName());
        }if (courseRequest.getDuration() == 0){
            course.setDuration(courseRequest.getDuration());
        }if (courseRequest.getDescription() != null){
            course.setDescription(courseRequest.getDescription());
        }
    }
}
