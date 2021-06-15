package com.org.microservice.ap.cursos.services;

import com.org.microservice.ap.cursos.models.entity.Curso;
import com.org.microservice.commons.services.CommonService;

public interface CursoService extends CommonService<Curso>{

	public Curso findCursoByAlumnoId(Long id);
}
