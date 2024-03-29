package com.example.service;



import com.example.dto.ProjectDTO;
import com.example.dto.TaskDTO;
import com.example.entity.User;
import com.example.enums.Status;

import java.util.List;

public interface TaskService {
    TaskDTO findById(Long id);
    List<TaskDTO> listAllTasks();
    void save(TaskDTO dto);
    void update(TaskDTO dto);
    void delete(Long id);
    int totalNonCompletedTask(String code);
    int totalCompletedTask(String code);
    void deleteByProject(ProjectDTO projectDTO);

    void completeByProject(ProjectDTO projectDTO);

    List<TaskDTO> listAllTaskByStatusIsNot(Status status);

    void updateStatus(TaskDTO dto);

    List<TaskDTO> listAllTasksByStatus(Status status);
    List<TaskDTO> listAllTasksByEmployee(User user);
}
