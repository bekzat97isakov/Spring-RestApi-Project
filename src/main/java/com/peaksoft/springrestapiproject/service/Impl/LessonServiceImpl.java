
package com.peaksoft.springrestapiproject.service.Impl;


import com.peaksoft.springrestapiproject.converter.lesson.LessonRequestConverter;
import com.peaksoft.springrestapiproject.converter.lesson.LessonResponseConverter;
import com.peaksoft.springrestapiproject.dto.request.LessonRequest;
import com.peaksoft.springrestapiproject.dto.responce.LessonResponse;
import com.peaksoft.springrestapiproject.entities.Course;
import com.peaksoft.springrestapiproject.entities.Lesson;
import com.peaksoft.springrestapiproject.repository.CourseRepository;
import com.peaksoft.springrestapiproject.repository.LessonRepository;
import com.peaksoft.springrestapiproject.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    private final LessonRequestConverter lessonRequestConverter;
    private final LessonResponseConverter lessonResponseConverter;


    @Override
    public List<LessonResponse> getAllLessons(Long id) {
        return lessonResponseConverter.view( lessonRepository.findAllLessonByCourseId(id));
    }

    @Override
    public LessonResponse addLesson(Long id, LessonRequest lessonRequest) {
        Course course = courseRepository.getById(id);
        Lesson lesson = lessonRequestConverter.createLesson(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return lessonResponseConverter.viewLesson(lessonRepository.getById(id));
    }

    @Override
    public LessonResponse updateLesson(Long id, LessonRequest lessonRequest) {
        Lesson lesson1 = lessonRepository.findById(id).get();
        lessonRequestConverter.updateLesson(lesson1,lessonRequest);
        lessonRepository.save(lesson1);
        return lessonResponseConverter.viewLesson(lesson1);
    }

    @Override
    public LessonResponse deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRepository.delete(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }
}