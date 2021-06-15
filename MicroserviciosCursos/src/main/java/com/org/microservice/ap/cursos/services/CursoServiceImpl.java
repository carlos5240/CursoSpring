package com.org.microservice.ap.cursos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.microservice.ap.cursos.models.entity.Curso;
import com.org.microservice.ap.cursos.models.repository.CursoRepository;
import com.org.microservice.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService{

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		// TODO Auto-generated method stub
		return repository.findCursoByAlumnoId(id);
	}

}
