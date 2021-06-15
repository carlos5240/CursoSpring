package com.org.microservice.app.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.microservice.app.examenes.services.ExamenService;
import com.org.microservice.commons.controller.CommonController;
import com.org.microservice.commons.examenes.model.entity.Examen;
import com.org.microservice.commons.examenes.model.entity.Pregunta;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Examen> o = service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDB = o.get();
		
		List<Pregunta> eliminadas = new ArrayList<>();
		examenDB.getPreguntas().forEach(pdb -> {
			if(!examen.getPreguntas().contains(pdb)) {
				eliminadas.add(pdb);
			}
		});
		
		eliminadas.forEach( p -> {
			examenDB.removePregunta(p);
		});
		
		/*
		 * OTRA OPCION
		 * 
		 * examenDB.getPreguntas().
		 * stream().
		 * filter(pdb -> !examen.getPreguntas().contains(pdb)).
		 * forEach(examenDB::removePreguntas);
		 * */
		
		examenDB.setPreguntas(examen.getPreguntas());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		
		return ResponseEntity.ok(service.findByNombre(term));
		
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		
		return ResponseEntity.ok(service.findAllAsignaturas());
	}
	

}
