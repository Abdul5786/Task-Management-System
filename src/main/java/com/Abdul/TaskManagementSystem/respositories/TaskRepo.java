package com.Abdul.TaskManagementSystem.respositories;

import com.Abdul.TaskManagementSystem.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Integer>
{
//      Task findByName(String title);
}
