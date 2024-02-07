package com.example.service.impl;

import com.example.dto.ProjectDTO;
import com.example.dto.UserDTO;
import com.example.entity.Project;
import com.example.entity.User;
import com.example.enums.Status;
import com.example.mapper.ProjectMapper;
import com.example.mapper.UserMapper;
import com.example.repository.ProjectRepository;
import com.example.service.ProjectService;
import com.example.service.TaskService;
import com.example.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserService userService;
    private final UserMapper userMapper;
    private final TaskService taskService;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper,@Lazy UserService userService, UserMapper userMapper, TaskService taskService) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.taskService = taskService;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
      return projectRepository.findAll().stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return projectMapper.convertToDto(projectRepository.findByProjectCode(code));
    }

    @Override
    public void save(ProjectDTO dto) {
        dto.setProjectStatus(Status.Open);
        projectRepository.save(projectMapper.convertToEntity(dto));
    }

    @Override
    public ProjectDTO update(ProjectDTO dto) {
        Project project = projectRepository.findByProjectCode(dto.getProjectCode());

        Project convertedProject = projectMapper.convertToEntity(dto);

        convertedProject.setId(project.getId());
        projectRepository.save(convertedProject);
        return projectMapper.convertToDto(convertedProject);
    }


    @Override
    public void delete(String code) {
        Project project = projectRepository.findByProjectCode(code);
        project.setIsDeleted(true);
        project.setProjectCode(project.getProjectCode()+"-"+project.getId());
        projectRepository.save(project);
        taskService.deleteByProject(projectMapper.convertToDto(project));
    }

    @Override
    public void complete(String code) {
        Project project = projectRepository.findByProjectCode(code);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
        taskService.completeByProject(projectMapper.convertToDto(project));

    }

    @Override
    public List<ProjectDTO> listAllProjectDetails() {
        String username = "admin@admin.com";
        UserDTO currentUserDTO = userService.findByUserName(username);
        User user = userMapper.convertToEntity(currentUserDTO);
        List<Project> list = projectRepository.findAllByAssignedManager(user);
        return list.stream().map(project -> {
            ProjectDTO obj = projectMapper.convertToDto(project);
            obj.setUnfinishedTaskCounts(taskService.totalNonCompletedTask(project.getProjectCode()));
            obj.setCompleteTaskCounts(taskService.totalCompletedTask(project.getProjectCode()));
            return obj;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> listAllProjectsByManager(User user) {
        return projectRepository.findAllByAssignedManager(user).stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }
}
