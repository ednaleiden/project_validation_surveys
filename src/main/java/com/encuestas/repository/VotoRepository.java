package com.encuestas.repository;

import com.encuestas.model.Encuesta;
import com.encuestas.model.Voto;
import org.springframework.data.repository.CrudRepository;

public interface VotoRepository extends CrudRepository<Voto, Long> {
}
