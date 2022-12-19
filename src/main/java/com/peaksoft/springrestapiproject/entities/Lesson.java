
package com.peaksoft.springrestapiproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_gen", allocationSize = 1)
    private Long id;
    @Column(length = 100000,name = "lesson_name")
    private String lessonName;

    @ManyToOne(cascade = {MERGE,DETACH,PERSIST,REFRESH},fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "lesson")
    private List<Task> taskList;
    public void addTask(Task task){
        if (taskList == null){
            taskList=new ArrayList<>();
        }
        taskList.add(task);
    }
}
