package com.org.microservice.app.examenes.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.org.microservice.commons.examenes.model.entity.Asignatura;

public interface AsignaturaRepository  extends PagingAndSortingRepository<Asignatura, Long>{

}
