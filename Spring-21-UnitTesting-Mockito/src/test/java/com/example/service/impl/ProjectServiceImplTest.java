package com.example.service.impl;

import com.example.dto.ProjectDTO;
import com.example.entity.Project;
import com.example.mapper.ProjectMapper;
import com.example.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;
    @Test
    void getByProjectCode_test(){
        // Given
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        //When
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        //Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO1);
    }

    @Test
    void getByProjectCode_exception_test(){
        //Given
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project not found"));

        //When
        Throwable exception = assertThrows(RuntimeException.class,()->projectService.getByProjectCode(""));

        //Then
        verify(projectRepository).findByProjectCode(anyString());

        assertEquals(exception.getMessage(),"Project not found");
    }

    @Test
    void save_test(){
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project);
    }



}