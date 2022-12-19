package com.peaksoft.springrestapiproject.repository;

import com.peaksoft.springrestapiproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select c from Student c where c.group.id = :groupId")
    List<Student> getAllListStudent(Long groupId);
    List<Student> findAllStudentByGroupId(Long id);
}
