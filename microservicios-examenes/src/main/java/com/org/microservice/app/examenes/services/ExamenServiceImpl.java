package com.org.microservice.app.examenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.microservice.app.examenes.models.repository.AsignaturaRepository;
import com.org.microservice.app.examenes.models.repository.ExamenRepository;
import com.org.microservice.commons.examenes.model.entity.Asignatura;
import com.org.microservice.commons.examenes.model.entity.Examen;
import com.org.microservice.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return asignaturaRepository.findAll();
	}

}
