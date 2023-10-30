package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoTelefono;
import com.db.donaldapi.repositories.TipoTelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposTelefono")
public class TipoTelefonoController {

    private final TipoTelefonoRepository tipoTelefonoRepository;

    @Autowired
    public TipoTelefonoController(TipoTelefonoRepository tipoTelefonoRepository) {
        this.tipoTelefonoRepository = tipoTelefonoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoTelefono> findAll(){
        return tipoTelefonoRepository.spReadTiposTelefono();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoTelefono tipoTelefono){
        tipoTelefonoRepository.spCreateTipoTelefono(
                tipoTelefono.getCodigoTipoTelefono(),
                tipoTelefono.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoTelefono tipoTelefono){
        tipoTelefonoRepository.spUpdateTipoTelefono(
                tipoTelefono.getCodigoTipoTelefono(),
                tipoTelefono.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoTipoTelefono}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoTelefono){
        tipoTelefonoRepository.spDeleteTipoTelefono(codigoTipoTelefono);
    }
}
