package com.Abdul.TaskManagementSystem.services;

import com.Abdul.TaskManagementSystem.Dtos.TasksDto;

import java.util.List;

public interface TaskService
{
    //   for creating tasks
    TasksDto createTasks(TasksDto tasksDto);

    // for getTING  tasks by Id
    TasksDto getTaskById(Integer taskId);

    // TO get all the tasks in the databases
    List<TasksDto> getAllTask();

    //to update Tasks by fetching using Id
    TasksDto updateTask(TasksDto tasksDto,Integer taskId);

    // to delete tasks
    void deleteTasks(Integer  taskId);

   // to update task status
    String updateTaskStatus(Integer taskId);

    // to find the task which are incompleted
    List<TasksDto> listOfIncompleteTask();

//    TasksDto SearchTaskName(String taskName);

}
