package com.Abdul.TaskManagementSystem.services.servicesImpl;

import com.Abdul.TaskManagementSystem.Dtos.TasksDto;
import com.Abdul.TaskManagementSystem.entities.Task;
import com.Abdul.TaskManagementSystem.enums.Status;
import com.Abdul.TaskManagementSystem.exception.ResourceNotFoundException;
import com.Abdul.TaskManagementSystem.respositories.TaskRepo;
import com.Abdul.TaskManagementSystem.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskRepo taskRepo;


    @Override
    public TasksDto createTasks(TasksDto tasksDto)
    {   // converting them dto to entity using modelmapper
        Task task = this.modelMapper.map(tasksDto,Task.class);
        task.setDate(new Date());
        task.setStatus(Status.incomplete);
        Task savedTask = taskRepo.save(task);
        return this.modelMapper.map(savedTask,TasksDto.class);
    }

    // getting task by Id
    @Override
    public TasksDto getTaskById(Integer taskId)
    {     // fetching Task by its Id and also using exception if task is not found
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("resource not found with resource ", "id", taskId));
        return this.modelMapper.map(task,TasksDto.class);
    }

    // getting all tasks by Id  then using stream apis to convert them into dtos
    @Override
    public List<TasksDto> getAllTask()
    {
        List<Task> allTaskRecords = taskRepo.findAll();
        List<TasksDto> allDtoTrackRecords = allTaskRecords.stream().map(t -> this.modelMapper.map(t,TasksDto.class)).collect(Collectors.toList());
        return allDtoTrackRecords;
    }

    // updating task by Id
    @Override
    public TasksDto updateTask(TasksDto tasksDto,Integer taskId)
    {
        // fetching task to update
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("resource not found with resource ", "id", taskId));
        task.setDescription(tasksDto.getDescription());
        task.setTitle(tasksDto.getTitle());
        return this.modelMapper.map(task,TasksDto.class);
    }

    @Override
    // deleting task by Id
    public void deleteTasks(Integer taskId)
    {
        taskRepo.deleteById(taskId);
    }

    @Override
    public String updateTaskStatus(Integer taskId)
    {
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("resource not found with resource ", "id", taskId));
        if(task.getStatus()!=null)
        {
            task.setStatus(Status.complete);
            return "Task is Updated Succesfully";
        }
        else {
             return "task is already updated";
        }

    }

    @Override  // to find the tasks which are complete using java 8 streams apis.
    public List<TasksDto> listOfIncompleteTask()
    {
        // fetching all the list first
        List<Task> all = taskRepo.findAll();
        // filtering the list of task which are completed using java8 Stream apis
        List<Task> completedTasks = all.stream().filter(task -> task.getStatus() == Status.complete).collect(Collectors.toList());
        // after getting the list of completed tasks converting them into listOfDtosTasks
        List<TasksDto> allCompleteTaskDtos = completedTasks.stream().map(cmpTask -> this.modelMapper.map(cmpTask, TasksDto.class)).collect(Collectors.toList());
        return allCompleteTaskDtos; // return list of completed tasks
    }

//    @Override
//    public TasksDto SearchTaskName(String taskName) {
//        Task name = taskRepo.findByName(taskName);
//////        if (name!=null)
//////        {
//////            return this.modelMapper.map(name,TasksDto.class);
//////        }
//////        else {
//////
//////             }
////    }
//
//        return this.modelMapper.map(name,TasksDto.class);
//    }

}
