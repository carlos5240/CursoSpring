package com.org.microservice.app.examenes.services;

import java.util.List;

import com.org.microservice.commons.examenes.model.entity.Asignatura;
import com.org.microservice.commons.examenes.model.entity.Examen;
import com.org.microservice.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen> {

	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
