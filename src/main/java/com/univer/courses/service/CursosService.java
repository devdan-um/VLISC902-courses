package com.univer.courses.service;

import com.univer.courses.model.entity.CoursesEntity;
import com.univer.courses.model.request.CoursesRequest;
import com.univer.courses.model.response.CursoResponse;
import com.univer.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class CursosService {

    @Autowired
    private CoursesRepository cursesRepository;

    public CursoResponse getCursos(Integer id){
        Optional<CoursesEntity> entity = this.cursesRepository.findById(id);

        if(entity.isPresent()){
            CursoResponse response = new CursoResponse();
            response.setNameCurso(entity.get().getName());

            return response;

        } else {
            return null;
        }
    }


    public CursoResponse saveCurso(CoursesRequest request){


        CoursesEntity entity = new CoursesEntity();
        entity.setName(request.getName());
        entity.setGrado(request.getGrado());

        this.cursesRepository.save(entity);

        CursoResponse response = new CursoResponse();
        response.setNameCurso(request.getName());
        return response;

    }}