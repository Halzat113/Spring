package com.example.service.impl;

import com.example.dto.TaskDTO;
import com.example.entity.Task;
import com.example.mapper.TaskMapper;
import com.example.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;
    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    //@ValueSource(longs = {1L,2L,3L,-5L})
    @ValueSource(longs = {1L,2L,3L,-5L})
    void findById_test(long id){

        Task task = new Task();

        if (id<=0){
            when(taskRepository.findById(id)).thenThrow(new RuntimeException());
            assertThrows(RuntimeException.class,()->taskRepository.findById(id));
        }else {

            when(taskRepository.findById(id)).thenReturn(Optional.of(task));
            when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

            taskService.findById(id);

            verify(taskRepository).findById(id);
            verify(taskMapper).convertToDto(any(Task.class));
        }
    }

    @Test
    void findById_bdd_test(){
        // Given
        Task task = new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        // When
        taskService.findById(anyLong());

        // Then
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }



}