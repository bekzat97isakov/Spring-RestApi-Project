package com.peaksoft.springrestapiproject.repository;

import com.peaksoft.springrestapiproject.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select c from Task c where c.lesson.id = :lessonId")
    List<Task> getAllTasks(Long lessonId);
    List<Task> findAllTaskByLessonId(Long id);
}
