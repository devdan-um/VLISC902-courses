package com.univer.courses.controller;

import com.univer.courses.model.entity.CoursesEntity;
import com.univer.courses.model.request.CursesRequest;
import com.univer.courses.repository.CursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CursesRestController {

    @Autowired
    private CursesRepository cursesRepository;

    @GetMapping("api/univer/curso/{id}")
            public String curso(@PathVariable String id){
        Optional<CoursesEntity> entity=
        this.cursesRepository.findById(Integer.parseInt(id));

        if(entity.isPresent()){
            return entity.get().getName();

        }else{
            return "No hay Registros con ese identificador";
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
