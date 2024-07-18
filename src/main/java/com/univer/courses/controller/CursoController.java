package com.univer.courses.controller;

import com.univer.courses.entity.MateriasEntity;
import com.univer.courses.model.response.CursoResponse;
import com.univer.courses.repository.CursoRepository;
import com.univer.courses.repository.MateriasRepository;
import com.univer.courses.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private MateriasRepository materiasRepository;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/api/univer/cuatrimestre/{id}")
    public ResponseEntity cursoPorId(@PathVariable Integer id){
        CursoResponse response = this.cursoService.getCurso(id);
        if(response != null){
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/api/univer/cuatrimestre/all")
    public ResponseEntity cursoPorId(){
        List<CursoResponse> response = this.cursoService.getAllCursos();
        if(response != null){
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/api/univer/materias/{idCurso}")
    public List<MateriasEntity> cursoPorIdCurso(@PathVariable Integer idCurso){

        if(materiasRepository.materiasByCurso(idCurso).isPresent()){
            return materiasRepository.materiasByCurso(idCurso).get();
        } else {
            return Arrays.asList(new MateriasEntity());
        }

    }

}
