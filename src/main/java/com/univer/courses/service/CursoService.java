package com.univer.courses.service;

import com.univer.courses.entity.CursoEntity;
import com.univer.courses.entity.MateriasEntity;
import com.univer.courses.model.request.MateriaRequest;
import com.univer.courses.model.response.CursoResponse;
import com.univer.courses.model.response.MateriaResponse;
import com.univer.courses.repository.CursoRepository;
import com.univer.courses.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MateriasRepository materiasRepository;

    public CursoResponse getCurso(Integer id){

        CursoResponse response = new CursoResponse();
        Optional<CursoEntity> entity = cursoRepository.findById(id);

        if(entity.isPresent()){
            response.setNombre(entity.get().getNombre());
            response.setDescripcion(entity.get().getDescripcion());
            response.setCuatrimestre(entity.get().getCuatrimestre());
            return response;
        } else {
            return null;
        }

    }

    public List<CursoResponse> getAllCursos(){

        List<CursoResponse> response = new ArrayList<>();

        cursoRepository.findAll().forEach(entity -> {
            CursoResponse c = new CursoResponse();
            c.setNombre(entity.getNombre());
            c.setDescripcion(entity.getDescripcion());
            c.setCuatrimestre(entity.getCuatrimestre());
            response.add(c);
        });

        return response;

    }

    public MateriaResponse saveMateria(MateriaRequest request){

        MateriasEntity me = new MateriasEntity();
        me.setNombre(request.getName());
        me.setHorasSemana(request.getHoraSemana());

        MateriaResponse response = null;

        Optional<CursoEntity> entity = cursoRepository.materiaByCuatrimestre(request.getCurso());

        if(entity.isPresent()){
            me.setCurso(entity.get());
            this.materiasRepository.save(me);
            response = new MateriaResponse();
            response.setNombre(request.getName());
            response.setCuatrimestre(entity.get().getNombre());
            return response;
        } else {
            return response;
        }

    }

}
