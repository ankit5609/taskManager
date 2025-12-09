package com.cybernode.taskmanager.controller;

import com.cybernode.taskmanager.model.Task;
import com.cybernode.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id){
        return taskService.getTask(id);
    }

    @PutMapping("/{id}")
    public  Task updateTask(@PathVariable String id, @RequestBody Task task){

    }
}
