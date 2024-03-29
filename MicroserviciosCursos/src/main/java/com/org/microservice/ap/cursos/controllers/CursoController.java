package com.org.microservice.ap.cursos.controllers;

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

import com.org.microservice.ap.cursos.models.entity.Curso;
import com.org.microservice.ap.cursos.services.CursoService;
import com.org.microservice.commons.alumnos.model.entity.Alumno;
import com.org.microservice.commons.controller.CommonController;
import com.org.microservice.commons.examenes.model.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso, CursoService>{
	
		@PutMapping("/{id}")
		public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id){
			
			if(result.hasErrors()) {
				return this.validar(result);
			}
			
			Optional<Curso> o = this.service.findById(id);
			
			if(!o.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Curso dbCurso = o.get();
			dbCurso.setNombre(curso.getNombre());
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
			
		}
		
		@PutMapping("/{id}/asignar-alumnos")
		public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
			
			Optional<Curso> o = this.service.findById(id);
			if(!o.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Curso dbCurso = o.get();
			
			alumnos.forEach(a -> {
				dbCurso.addAlumno(a);
			});
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
		}
		
		@PutMapping("/{id}/eliminar-alumno")
		public ResponseEntity<?> elimianrAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
			
			Optional<Curso> o = this.service.findById(id);
			if(!o.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Curso dbCurso = o.get();
			dbCurso.removeAlumno(alumno);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
		}
		
		@GetMapping("/alumno/{id}")
		public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id){
			Curso curso = service.findCursoByAlumnoId(id);
			return ResponseEntity.ok(curso);
		}
		
		@PutMapping("/{id}/asignar-examenes")
		public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id){
			
			Optional<Curso> o = this.service.findById(id);
			if(!o.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Curso dbCurso = o.get();
			
			examenes.forEach(a -> {
				dbCurso.addExamen(a);
			});
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
		}
		
		@PutMapping("/{id}/eliminar-examen")
		public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id){
			
			Optional<Curso> o = this.service.findById(id);
			if(!o.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Curso dbCurso = o.get();
			dbCurso.removeExamen(examen);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
		}

}
