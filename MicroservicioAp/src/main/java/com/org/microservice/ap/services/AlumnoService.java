package com.org.microservice.ap.services;

import java.util.List;
import java.util.Optional;

import com.org.microservice.commons.alumnos.model.entity.Alumno;
import com.org.microservice.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno>{
	
	public List<Alumno> findByNombreOrApellido(String term);

}
