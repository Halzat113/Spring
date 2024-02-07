package com.example.mapper;


import com.example.dto.UserDTO;
import com.example.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User convertToEntity(UserDTO dto){
        return mapper.map(dto,User.class);
    }
    public UserDTO convertToDto(User entity){
        return mapper.map(entity,UserDTO.class);
    }
}
