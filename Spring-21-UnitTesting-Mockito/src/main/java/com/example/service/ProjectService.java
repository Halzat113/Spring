package com.example.service;

import com.example.dto.ProjectDTO;
import com.example.entity.User;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> listAllProjects();
    ProjectDTO getByProjectCode(String code);
    void save(ProjectDTO dto);
    ProjectDTO update(ProjectDTO dto);
    void delete(String code);
    void complete(String code);
    List<ProjectDTO> listAllProjectDetails();
    List<ProjectDTO> listAllProjectsByManager(User user);
}
