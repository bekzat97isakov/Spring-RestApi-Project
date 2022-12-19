package com.peaksoft.springrestapiproject.converter.lesson;

import com.peaksoft.springrestapiproject.dto.request.LessonRequest;
import com.peaksoft.springrestapiproject.entities.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestConverter {
    public Lesson createLesson(LessonRequest lessonRequest){
        if (lessonRequest==null){
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lesson.getLessonName());
        return lesson;

    }
    public void updateLesson(Lesson lesson, LessonRequest lessonRequest){
        lesson.setLessonName(lessonRequest.getLessonName());
    }
}
