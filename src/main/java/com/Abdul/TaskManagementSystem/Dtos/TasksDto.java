package com.Abdul.TaskManagementSystem.Dtos;

import com.Abdul.TaskManagementSystem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksDto
{
    private String id;
    private String title;
    private String description;
    private Date date;
    private Status status;
}
