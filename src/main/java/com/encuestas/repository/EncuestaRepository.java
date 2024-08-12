package com.encuestas.repository;

import com.encuestas.model.Encuesta;
import org.springframework.data.repository.CrudRepository;

public interface EncuestaRepository extends CrudRepository<Encuesta, Long> {
}
