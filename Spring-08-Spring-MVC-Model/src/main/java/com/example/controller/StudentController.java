package com.example.controller;

import com.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model){

        //model methods
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        //create some random studentID(0-1000) and show it in your UI
        int studentId = new Random().nextInt();
        model.addAttribute("id",studentId);

        List<Integer> numbers = List.of(4,5,6,7,8);
        model.addAttribute("numbers",numbers);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);

        return "/student/welcome";
    }
}
