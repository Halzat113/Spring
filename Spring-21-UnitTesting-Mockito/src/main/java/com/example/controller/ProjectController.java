package com.example.controller;

import com.example.dto.ProjectDTO;
import com.example.service.ProjectService;
import com.example.service.UserService;
import com.example.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects",projectService.listAllProjectDetails());
        model.addAttribute("managers",userService.listAllByRole("manager"));
        return "/project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project")ProjectDTO projectDTO){
        projectService.save(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode")String projectCode,Model model){
        model.addAttribute("project",projectService.getByProjectCode(projectCode));
        model.addAttribute("projects",projectService.listAllProjectDetails());
        model.addAttribute("managers",userService.listAllByRole("manager"));
        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project")ProjectDTO projectDTO){
        projectService.update(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode")String projectCode){
        projectService.delete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode")String projectCode){
        projectService.complete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/status")
    public String getProjectStatus(Model model){
        List<ProjectDTO> projects = projectService.listAllProjectDetails();
        model.addAttribute("projects",projects);
        return "/manager/project-status";
    }
    @GetMapping("/manager/complete/{projectCode}")
    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectCode);
        return "redirect:/project/status";
    }
}
