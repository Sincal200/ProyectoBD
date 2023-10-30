package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateAutomovilDto;
import com.db.donaldapi.models.entities.Automovil;
import com.db.donaldapi.repositories.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automoviles")
public class AutomovilController {

    private final AutomovilRepository automovilRepository;

    @Autowired
    public AutomovilController(AutomovilRepository automovilRepository) {
        this.automovilRepository = automovilRepository;
    }


    @GetMapping("/{codigoAutomovil}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public Automovil findById(@PathVariable Integer codigoAutomovil){
        return automovilRepository.sp_LeerAutomovil(codigoAutomovil);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Automovil automovil){
        automovilRepository.sp_CrearAutomovil(
                automovil.getCodigoAutomovil(),
                automovil.getPlaca(),
                automovil.getColor(),
                automovil.getVIN(),
                automovil.getMotor(),
                automovil.getModelo(),
                automovil.getCodigoModelo(),
                automovil.getCodigoMarca()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateAutomovilDto automovil){
        automovilRepository.sp_ActualizarAutomovil(
                automovil.getCodigoAutomovil(),
                automovil.getColor()
        );
    }

    @DeleteMapping("/{codigoAutomovil}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoAutomovil){
        automovilRepository.sp_BorrarAutomovil(codigoAutomovil);
    }
}
