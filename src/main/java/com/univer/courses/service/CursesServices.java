package com.univer.courses.service;

import com.univer.courses.entity.CoursesEntity;
import com.univer.courses.model.reponse.CursesResponse;
import com.univer.courses.repository.CursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CursesServices {

    @Autowired
    private CursesRepository cursesRepository;

    public CursesResponse getAllCurses(Integer id) {
        Optional<CoursesEntity> entity=
                this.cursesRepository.findById(id);

        if(entity.isPresent()){
            CursesResponse response = new CursesResponse();
            response.setName(entity.get().getName());
            return response;

        }else{
            return null;
        }
    }
}
