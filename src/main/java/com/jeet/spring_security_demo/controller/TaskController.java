package com.jeet.spring_security_demo.controller;

import com.jeet.spring_security_demo.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private final List<Task> tasks = new ArrayList<>(List.of(
            new Task(1, "Learn Spring Security"),
            new Task(2, "Push project to GitHub")
    ));

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }
}