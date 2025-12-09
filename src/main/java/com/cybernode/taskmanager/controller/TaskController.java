package com.cybernode.taskmanager.controller;

import com.cybernode.taskmanager.model.Task;
import com.cybernode.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createtask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return new ArrayList<>(taskService.getAllTask());
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id){
        return taskService.getTask(id);
    }

    @PutMapping("/{id}")
    public  Task updateTask(@PathVariable String id, @RequestBody Task data){
        return taskService.updateTask(id,data);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id){
        boolean possible= taskService.deleteTask(id);
        return possible?"Task with id="+id+" has been deleted Successfully" : "No Task is associated with id="+id;
    }
}
