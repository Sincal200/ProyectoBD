package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoAsistencia;
import com.db.donaldapi.repositories.TipoAsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-asistencia")
public class TipoAsistenciaController {

    private final TipoAsistenciaRepository tipoAsistenciaRepository;

    @Autowired
    public TipoAsistenciaController(TipoAsistenciaRepository tipoAsistenciaRepository) {
        this.tipoAsistenciaRepository = tipoAsistenciaRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoAsistencia> findAll(){
        return tipoAsistenciaRepository.spReadTiposAsistencia();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoAsistencia tipoAsistencia){
        tipoAsistenciaRepository.spCreateTipoAsistencia(
                tipoAsistencia.getCodigoTipoAsistencia(),
                tipoAsistencia.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoAsistencia tipoAsistencia){
        tipoAsistenciaRepository.spUpdateTipoAsistencia(
                tipoAsistencia.getCodigoTipoAsistencia(),
                tipoAsistencia.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoTipoAsistencia}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoAsistencia){
        tipoAsistenciaRepository.spDeleteTipoAsistencia(codigoTipoAsistencia);
    }
}
