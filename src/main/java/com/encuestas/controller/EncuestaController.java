package com.encuestas.controller;

import com.encuestas.model.Encuesta;
import com.encuestas.repository.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class EncuestaController {

    @Autowired
    private EncuestaRepository encuestaRepository;


    @GetMapping("/encuestas")
    public ResponseEntity<Iterable<Encuesta>> listarTodasLasEncuestas() {
        return new  ResponseEntity<>(encuestaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/encuestas")
    public ResponseEntity<?> crearEncuesta(@RequestBody Encuesta encuesta) {


        HttpHeaders httpHeaders = new HttpHeaders();

        URI newEncuesta = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encuesta.getId()).toUri();
        httpHeaders.setLocation(newEncuesta);
        return  new ResponseEntity<>(null,HttpStatus.CREATED);
    }

    @GetMapping("/encuestas/{encuestasid}")
    public  ResponseEntity<?> obtenerEncuestas(String encuestasid){
        Optional<Encuesta> encuesta = encuestaRepository.findById(Long.valueOf(encuestasid));

        if (encuesta.isPresent()){
            return new ResponseEntity<>(encuesta, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/encuestas/{encuestasid}")
    public ResponseEntity   <?> actualizarEncuesta(@RequestBody Encuesta encuesta ,@PathVariable Long encuestasid) {
        encuesta.setId(encuestasid);
        Encuesta e = encuestaRepository.save(encuesta);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/encuestas/{encuestasid}")
    public ResponseEntity<Object> deleteEncuestas(@PathVariable Long id){
        encuestaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
