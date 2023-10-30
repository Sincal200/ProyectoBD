package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.OrdenDeTrabajo;
import com.db.donaldapi.repositories.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenesDeTrabajo")
public class OrdenDeTrabajoController {

    private final OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    public OrdenDeTrabajoController(OrdenDeTrabajoRepository ordenDeTrabajoRepository) {
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<OrdenDeTrabajo> findAll(){
        return ordenDeTrabajoRepository.usp_GetOrdenesDeTrabajo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody OrdenDeTrabajo ordenDeTrabajo){
        ordenDeTrabajoRepository.usp_CreateOrdenDeTrabajo(
                ordenDeTrabajo.getNumeroOrden(),
                ordenDeTrabajo.getFechaOrden(),
                ordenDeTrabajo.getEstado(),
                ordenDeTrabajo.getNumeroCita()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody OrdenDeTrabajo ordenDeTrabajo){
        ordenDeTrabajoRepository.usp_UpdateOrdenDeTrabajo(
                ordenDeTrabajo.getNumeroOrden(),
                ordenDeTrabajo.getFechaOrden(),
                ordenDeTrabajo.getEstado(),
                ordenDeTrabajo.getNumeroCita()
        );
    }

    @DeleteMapping("/{numeroOrden}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroOrden){
        ordenDeTrabajoRepository.usp_DeleteOrdenDeTrabajo(numeroOrden);
    }
}
