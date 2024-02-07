package com.example.mapper;

import com.example.dto.ProjectDTO;
import com.example.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private final ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //convertToEntity
    public Project convertToEntity(ProjectDTO dto){
        return modelMapper.map(dto,Project.class);
    }
    //convertToDto
    public ProjectDTO convertToDto(Project entity){
        return modelMapper.map(entity,ProjectDTO.class);
    }
}
