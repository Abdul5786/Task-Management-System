package com.Abdul.TaskManagementSystem.controllers;

import com.Abdul.TaskManagementSystem.Dtos.TasksDto;
import com.Abdul.TaskManagementSystem.services.servicesImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@CrossOrigin("*")
public class TaskControlller
{
    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping(value = "/addTask")
    public ResponseEntity<TasksDto> addTask(@RequestBody TasksDto tasksDto)
    {
        TasksDto tasks = taskService.createTasks(tasksDto);
        return new ResponseEntity<>(tasks, HttpStatus.CREATED);
    }
    @GetMapping(value = "/getTask/{taskId}")
    public ResponseEntity<TasksDto> getTaskById(@PathVariable Integer taskId)
    {
        TasksDto taskById = taskService.getTaskById(taskId);
        return new ResponseEntity<>(taskById,HttpStatus.FOUND);
    }
    @GetMapping(value ="/getAllTasks" )
    public ResponseEntity<List<TasksDto>> getAllTasks()
    {
        List<TasksDto> allTask = taskService.getAllTask();
        return ResponseEntity.ok(allTask);
    }
    @PutMapping(value = "/updateTask/{taskId}")
    public ResponseEntity<TasksDto> updateTask(@RequestBody TasksDto tasksDto,@PathVariable Integer taskId)
    {
        TasksDto updateTasks = taskService.updateTask(tasksDto, taskId);
        return ResponseEntity.ok(updateTasks);

    }

    @PutMapping(value = "/updateTaskStatus/{taskId}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Integer taskId)
    {
        String message = taskService.updateTaskStatus(taskId);
        return ResponseEntity.ok(message);
    }

      @GetMapping(value = "/allCompleteTask")
     public ResponseEntity<List<TasksDto>> completedTasksList()
     {
         List<TasksDto> completedTaskList = taskService.listOfIncompleteTask();
         return ResponseEntity.ok(completedTaskList);
     }

//      public ResponseEntity<TasksDto> getTaskByTaskName(@PathVariable String Title)
//      {
//          TasksDto tasksDto = taskService.SearchTaskName(Title);
//      }

}
