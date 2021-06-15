package com.org.microservice.ap.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.microservice.commons.alumnos.model.entity.Alumno;
import com.org.microservice.ap.models.repository.AlumnoRepository;
import com.org.microservice.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>  implements AlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombreOrApellido(term);
	}

}
