package com.univer.courses.controller;

import com.univer.courses.model.entity.CoursesEntity;
import com.univer.courses.model.request.CoursesRequest;
import com.univer.courses.model.response.CursoResponse;
import com.univer.courses.repository.CoursesRepository;
import com.univer.courses.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CursoRestController {
    private com.univer.courses.service.CursosService CursosService;
    private com.univer.courses.service.CursosService CursosServive;

    public ResponseEntity cursos(@PathVariable String id){
        CursoResponse response = this.CursosService.getCursos(Integer.parseInt(id));



        if(response == null){

            return new ResponseEntity<>(response, HttpStatus.OK);


        }else {
            return new ResponseEntity<>("no se tiene registro de ese ID", HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/api/univer/curso")
    public ResponseEntity guardado(@RequestBody CoursesRequest request){

    CursoResponse response = this.CursosServive.saveCurso(request);


        return new  ResponseEntity (response, HttpStatus.CREATED);
    }
}