package com.peaksoft.springrestapiproject.converter.task;

import com.peaksoft.springrestapiproject.dto.request.TaskRequest;
import com.peaksoft.springrestapiproject.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskRequestConverter {
    public Task createTask(TaskRequest taskRequest){
        if (taskRequest==null){
            return null;
        }
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
        return task;
    }
    public void updateTask(TaskRequest taskRequest, Task task){
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
    }
}
