package com.example.converter;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter  implements Converter<String, UserDTO>{
    private final UserService userService;

    public UserDtoConverter(@Lazy UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }
}
