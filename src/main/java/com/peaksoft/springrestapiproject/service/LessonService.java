package com.peaksoft.springrestapiproject.service;

import com.peaksoft.springrestapiproject.dto.request.LessonRequest;
import com.peaksoft.springrestapiproject.dto.responce.LessonResponse;
import com.peaksoft.springrestapiproject.entities.Lesson;

import java.util.List;

public interface LessonService {
    List<LessonResponse> getAllLessons(Long courseId);

    LessonResponse addLesson(Long id, LessonRequest lesson);

    LessonResponse getLessonById(Long id);


    LessonResponse updateLesson(Long id, LessonRequest lessonRequest);

    LessonResponse deleteLesson(Long id);
}
