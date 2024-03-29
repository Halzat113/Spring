package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService){
        this.roleService = roleService;
        this.userService = userService;
    }
    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user")UserDTO user){
        userService.save(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username,Model model){
        model.addAttribute("user",userService.findByUserName(username));
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user")UserDTO user){
        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        //userService.deleteByUserName(username);
        userService.delete(username);
        return "redirect:/user/create";
    }
}
