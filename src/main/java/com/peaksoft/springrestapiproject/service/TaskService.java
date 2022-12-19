package com.peaksoft.springrestapiproject.service;

import com.peaksoft.springrestapiproject.dto.request.TaskRequest;
import com.peaksoft.springrestapiproject.dto.responce.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAlTasks(Long lessonId);

    TaskResponse addTask(Long id, TaskRequest taskrequest);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    TaskResponse deleteTask(Long id);
}