package com.cybernode.taskmanager.service;

import com.cybernode.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import java.util.*;
@Service

public class TaskService {
    Map<String,Task> taskDB=new HashMap<>();

    public Task createtask(Task task){
        String id = taskDB.size() + 1 + ""; // String id = UUID.randomUUID().toString();  will yse thing after designing UI
        task.setId(id);
        taskDB.put(task.getId(),task);
        return task;
    }
    public boolean deleteTask(String id){
        return taskDB.remove(id)!=null;
    }

    public Task updateTask(String id,Task updated){
        Task temp=taskDB.get(id);
        if(temp==null){
            return null;
        }
        if(updated.getName()!=null){
            temp.setName(updated.getName());
        }
        if(updated.getStatus()!=null){
            temp.setStatus(updated.getStatus());
        }
        taskDB.put(id,temp);
        return temp;
    }

    public Task getTask(String id){
        return taskDB.get(id);
    }

    public List<Task> getAllTask(){
        return new ArrayList<>(taskDB.values());
    }
}
