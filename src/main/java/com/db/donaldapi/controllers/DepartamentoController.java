package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Departamento;
import com.db.donaldapi.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoController(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Departamento> findAll(){
        return departamentoRepository.sp_leer_departamentos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Departamento departamento){
        departamentoRepository.sp_insertar_departamento(
                departamento.getCodigoDepartamento(),
                departamento.getDescripcion());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Departamento departamento){
        departamentoRepository.sp_actualizar_departamento(
                departamento.getCodigoDepartamento(),
                departamento.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoDepartamento}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoDepartamento){
        departamentoRepository.sp_eliminar_departamento(codigoDepartamento);
    }
}
