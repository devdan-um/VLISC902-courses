package com.univer.courses.controller;

import com.univer.courses.entity.CoursesEntity;
import com.univer.courses.model.request.CoursesRequest;
import com.univer.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoursesController {
    @Autowired
    private CoursesRepository studentRepository;

    @GetMapping("curses/register")
    public String student(){
        return "register";


    }
    @PostMapping("success")
    public String success(@ModelAttribute CoursesRequest request){
        CoursesEntity curso = new CoursesEntity();
        curso.setName(request.getName());

        this.studentRepository.save(curso);

        System.out.println(request);
        return "success";
}
}