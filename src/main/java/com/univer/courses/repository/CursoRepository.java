package com.univer.courses.repository;

import com.univer.courses.entity.CursoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, Integer> {
    @Query("SELECT c " +
            "FROM CursoEntity c " +
            "WHERE c.cuatrimestre = :idCurso")
    Optional<CursoEntity> materiaByCuatrimestre(Integer idCurso);
}
