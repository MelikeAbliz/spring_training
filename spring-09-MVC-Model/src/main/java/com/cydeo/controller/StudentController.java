package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model){//        method model interface, I want to execute method belong to interface
        //static-> put never changes html files,ex: image,javaScrip,css
//        template-> put hold data , change files
//        model-> carry data to view by using addAttribute method
        //view->thymeleaf


        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");
        return "student/welcome";
    }
}
