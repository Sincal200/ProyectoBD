package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.DepartamentoTrabajo;
import com.db.donaldapi.repositories.DepartamentoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos-trabajo")
public class DepartamentoTrabajoController {

    private final DepartamentoTrabajoRepository departamentoTrabajoRepository;

    @Autowired
    public DepartamentoTrabajoController(DepartamentoTrabajoRepository departamentoTrabajoRepository) {
        this.departamentoTrabajoRepository = departamentoTrabajoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<DepartamentoTrabajo> findAll(){
        return departamentoTrabajoRepository.sp_leer_departamentos_trabajo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody DepartamentoTrabajo departamentoTrabajo){
        departamentoTrabajoRepository.sp_insertar_departamento_trabajo(
                departamentoTrabajo.getCodigoDepartamentoTrabajo(),
                departamentoTrabajo.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody DepartamentoTrabajo departamentoTrabajo){
        departamentoTrabajoRepository.sp_actualizar_departamento_trabajo(
                departamentoTrabajo.getCodigoDepartamentoTrabajo(),
                departamentoTrabajo.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoDepartamentoTrabajo}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoDepartamentoTrabajo){
        departamentoTrabajoRepository.sp_eliminar_departamento_trabajo(codigoDepartamentoTrabajo);
    }
}
