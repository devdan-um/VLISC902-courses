package com.univer.courses.controller;

import com.univer.courses.entity.CoursesEntity;
import com.univer.courses.model.request.CoursesRequest;
import com.univer.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class CursoRestController {
    @Autowired
    private CoursesRepository CoursesRepository;

    @GetMapping ("api/univer/cursos/{id}")

    public String cursos(@PathVariable String id) {
        Optional<CoursesEntity> entity=
        this.CoursesRepository.findById(Integer.parseInt(id));

        if(entity.isPresent()){
            return entity.get().getName();

        }else {
            return"no hay registros con este identificador";
        }
    }
@PostMapping("/api/univer/curso")
    public ResponseEntity guardado(@RequestBody CoursesRequest request){
       CoursesEntity entity = new CoursesEntity();
       entity.setName(request.getName());
       entity.setGrado(request.getGrado());

       this.CoursesRepository.save(entity);

       return ResponseEntity.ok("se guardo de manera correcta");
}
}
