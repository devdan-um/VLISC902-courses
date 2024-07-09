package com.univer.courses.controller;

import com.univer.courses.entity.CoursesEntity;
import com.univer.courses.model.reponse.CursesResponse;
import com.univer.courses.model.request.CursesRequest;
import com.univer.courses.repository.CursesRepository;
import com.univer.courses.service.CursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CursesRestController {

    @Autowired
    private CursesRepository cursesRepository;

    @Autowired
    private CursesServices cursesServices;

    @GetMapping("api/univer/curso/{id}")
            public ResponseEntity curso(@PathVariable String id){

        CursesResponse response = this.cursesServices.getAllCurses(Integer.parseInt(id));

        if(response == null){
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            return new ResponseEntity<>("No se tiene registro de ese ID", HttpStatus.NO_CONTENT);
        }


    }

    @PostMapping("/api/univer/curso")
    public ResponseEntity guardado(@RequestBody CursesRequest request){

        CoursesEntity entity = new CoursesEntity();
        entity.setName(request.getName());
        entity.setGrado(request.getGrado());

        this.cursesRepository.save(entity);

        return ResponseEntity.ok("Se guardo de manera correcta");

    }
}
