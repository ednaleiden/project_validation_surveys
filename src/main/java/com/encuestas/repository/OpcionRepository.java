package com.encuestas.repository;


import com.encuestas.model.Opcion;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;

public interface OpcionRepository extends CrudRepository<Opcion, Long> {
}
