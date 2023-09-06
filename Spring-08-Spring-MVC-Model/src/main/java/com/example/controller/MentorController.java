package com.example.controller;

import com.example.model.Gender;
import com.example.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {
    @RequestMapping("/mentor")
    public String mentor(Model model){
        Mentor mentor = new Mentor("Mike","Smith",45, Gender.MALE);
        Mentor mentor2 = new Mentor("Tom","Hanks",65, Gender.MALE);
        Mentor mentor3 = new Mentor("Amy","Bryan",25, Gender.FEMALE);

        model.addAttribute("mentor",mentor);
        model.addAttribute("mentor2",mentor2);
        model.addAttribute("mentor3",mentor3);

        return "mentor/mentor";
    }
}
