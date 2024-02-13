package com.Abdul.TaskManagementSystem.entities;

import com.Abdul.TaskManagementSystem.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Tasks")
@NoArgsConstructor
@Getter
@Setter
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title",nullable = false,length = 200)
    private String title;
    @Column(name = "description",nullable = false,length = 2000)
    private String description;
     @Column(name="Task_status")
    private Status status;
    @Column(name = "Date")
    private Date date;

}
