package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.Taller;
import com.db.donaldapi.repositories.TallerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talleres")
public class TallerController {

    private final TallerRepository tallerRepository;

    @Autowired
    public TallerController(TallerRepository tallerRepository) {
        this.tallerRepository = tallerRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Taller> findAll(){
        return tallerRepository.spReadTalleres();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Taller taller){
        tallerRepository.spCreateTaller(
                taller.getCodigoTaller(),
                taller.getRazonSocial(),
                taller.getNombreComercial(),
                taller.getNIT()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Taller taller){
        tallerRepository.spUpdateTaller(
                taller.getCodigoTaller(),
                taller.getRazonSocial(),
                taller.getNombreComercial(),
                taller.getNIT()
        );
    }

    @DeleteMapping("/{codigoTaller}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTaller){
        tallerRepository.spDeleteTaller(codigoTaller);
    }
}
