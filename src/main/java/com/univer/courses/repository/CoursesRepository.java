package com.univer.courses.repository;

import com.univer.courses.entity.CoursesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends CrudRepository<CoursesEntity, Integer> {
}
