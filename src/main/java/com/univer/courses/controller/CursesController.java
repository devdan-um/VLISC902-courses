package com.univer.courses.controller;


import com.univer.courses.entity.CoursesEntity;
import com.univer.courses.model.request.CursesRequest;
import com.univer.courses.repository.CursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CursesController {

    @Autowired
    private CursesRepository cursesRepository;

    @GetMapping("Curses/register")
    public String Curses() {
        return "register";
    }

    @PostMapping("success")
    public String success(@ModelAttribute CursesRequest request) {

        CoursesEntity curso = new CoursesEntity();
        curso.setName(request.getName());
        this.cursesRepository.save(curso);


        System.out.println(request);
        return "success";
    }

}
