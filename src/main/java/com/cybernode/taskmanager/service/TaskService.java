package com.cybernode.taskmanager.service;

import com.cybernode.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import java.util.*;
@Service

public class TaskService {
    Map<String,Task> taskDB=new HashMap<>();

    public Task createtask(Task task){
        taskDB.put(task.getId(),task);
        return task;
    }
    public String deleteTask(String id){
        taskDB.remove(id);
        return "Deleted Task with id "+id;
    }
    public Task updateTask(Task task){
        taskDB.put(task.getId(),task);
        return task;
    }
    public Task getTask(String id){
        return taskDB.get(id);
    }
}
