package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/manage-students")
    @PreAuthorize(("hasAuthority('PROFESSOR')")) // 학생은 접근이 불가
    public ModelAndView manageStudents(){
        ModelAndView modelAndView = new ModelAndView("manage-students");
        return modelAndView;
    }
}
