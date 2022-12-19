package com.peaksoft.springrestapiproject.repository;

import com.peaksoft.springrestapiproject.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query(value = "select c from Lesson c where c.course.id = :courseId")
    List<Lesson> getAllLessons(Long courseId);
    List<Lesson> findAllLessonByCourseId(Long id);
}
