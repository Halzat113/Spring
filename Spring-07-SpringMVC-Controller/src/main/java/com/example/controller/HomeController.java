package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Annotate the class with @Controller stereotype annotation
public class HomeController {
    @RequestMapping("/home") //User @Request Mapping annotation to associate the action with an HTTP request path
    public String home(){
        return "home.html"; //Return the HTML document name that contains the details we want the browser to dispay
    }

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }
}
