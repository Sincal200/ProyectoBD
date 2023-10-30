package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoSocioNegocio;
import com.db.donaldapi.repositories.TipoSocioNegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposSocioNegocio")
public class TipoSocioNegocioController {

    private final TipoSocioNegocioRepository tipoSocioNegocioRepository;

    @Autowired
    public TipoSocioNegocioController(TipoSocioNegocioRepository tipoSocioNegocioRepository) {
        this.tipoSocioNegocioRepository = tipoSocioNegocioRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoSocioNegocio> findAll(){
        return tipoSocioNegocioRepository.spReadTiposSocioNegocio();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoSocioNegocio tipoSocioNegocio){
        tipoSocioNegocioRepository.spCreateTipoSocioNegocio(
                tipoSocioNegocio.getCodigoTipoSocioNegocio(),
                tipoSocioNegocio.getDescripcion(),
                tipoSocioNegocio.getEsPersona()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoSocioNegocio tipoSocioNegocio){
        tipoSocioNegocioRepository.spUpdateTipoSocioNegocio(
                tipoSocioNegocio.getCodigoTipoSocioNegocio(),
                tipoSocioNegocio.getDescripcion(),
                tipoSocioNegocio.getEsPersona()
        );
    }

    @DeleteMapping("/{codigoTipoSocioNegocio}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoSocioNegocio){
        tipoSocioNegocioRepository.spDeleteTipoSocioNegocio(codigoTipoSocioNegocio);
    }
}
