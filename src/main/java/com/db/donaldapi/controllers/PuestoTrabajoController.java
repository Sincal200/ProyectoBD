package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.PuestoTrabajo;
import com.db.donaldapi.repositories.PuestoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestosTrabajo")
public class PuestoTrabajoController {

    private final PuestoTrabajoRepository puestoTrabajoRepository;

    @Autowired
    public PuestoTrabajoController(PuestoTrabajoRepository puestoTrabajoRepository) {
        this.puestoTrabajoRepository = puestoTrabajoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<PuestoTrabajo> findAll(){
        return puestoTrabajoRepository.usp_GetPuestoTrabajo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody PuestoTrabajo puestoTrabajo){
        puestoTrabajoRepository.usp_CretePuestoTrabajo(
                puestoTrabajo.getCodigoPuestoTrabajo(),
                puestoTrabajo.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody PuestoTrabajo puestoTrabajo){
        puestoTrabajoRepository.usp_UpdatePuestoTrabajo(
                puestoTrabajo.getCodigoPuestoTrabajo(),
                puestoTrabajo.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoPuestoTrabajo}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoPuestoTrabajo){
        puestoTrabajoRepository.usp_DetletePuestoTrabajo(
                codigoPuestoTrabajo
        );
    }
}
