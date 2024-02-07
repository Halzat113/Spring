package com.example.service.impl;

import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUsername_test() {
        String username = "mikesmith@cydeo.com";
        userService.deleteByUserName(username);

//        verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, times(2)).deleteByUserName("mikesmith@gmail.com");
//        verify(userRepository, atLeast(1)).deleteByUserName("mikesmith@cydeo.com");
        InOrder inOrder = inOrder(userRepository);
        inOrder.verify(userRepository).deleteByUserName(username);
        inOrder.verify(userRepository).findAll();

    }

}