package com.example.controller;

import com.example.entity.Account;
import com.example.entity.User;
import com.example.repository.AccountRepository;
import com.example.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers(){
       return userRepository.findAll();
    }

    @GetMapping
    public List<Account> readAllAccount(){
        return accountRepository.findAll();
    }
}
