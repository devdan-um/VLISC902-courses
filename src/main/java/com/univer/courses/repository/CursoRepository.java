package com.univer.courses.repository;

import com.univer.courses.entity.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, Integer> {
}
