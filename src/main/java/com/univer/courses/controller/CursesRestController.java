package com.univer.courses.controller;

import com.univer.courses.model.entity.CoursesEntity;
import com.univer.courses.model.request.CursesRequest;
import com.univer.courses.model.response.CursesResponse;
import com.univer.courses.repository.CursesRepository;
import com.univer.courses.service.CursesService;
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
    private CursesService cursesService;

    @GetMapping("api/univer/cursos/{id}")
    public ResponseEntity Curses(@PathVariable String id){

        CursesResponse response = this.cursesService.getCurso(Integer.parseInt(id));


        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }else{
         return new ResponseEntity<>("no se tiene registro de este ID", HttpStatus.NO_CONTENT);
        }


    }
    @PostMapping("/api/univer/cursos")
    public ResponseEntity guardado(@RequestBody CursesRequest request){
      CoursesEntity entity = new CoursesEntity();
      entity.setName(request.getName());
      entity.setGRADO(request.getGRADO());

      this.cursesRepository.save(entity);

      return  ResponseEntity.ok( "se guardo de manera correcta");
    }
}
