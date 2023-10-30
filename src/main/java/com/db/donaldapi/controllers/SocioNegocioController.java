package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.SocioNegocio;
import com.db.donaldapi.repositories.SocioNegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sociosNegocio")
public class SocioNegocioController {

    private final SocioNegocioRepository socioNegocioRepository;

    @Autowired
    public SocioNegocioController(SocioNegocioRepository socioNegocioRepository) {
        this.socioNegocioRepository = socioNegocioRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<SocioNegocio> findAll(){
        return socioNegocioRepository.spReadSocios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody SocioNegocio socioNegocio){
        socioNegocioRepository.spCreateSocio(
                socioNegocio.getCodigoSocio(),
                socioNegocio.getPrimerNombre(),
                socioNegocio.getSegundoNombre(),
                socioNegocio.getPrimerApellido(),
                socioNegocio.getSegundoApellido(),
                socioNegocio.getFechaNacimiento(),
                socioNegocio.getCUI(),
                socioNegocio.getNIT(),
                socioNegocio.getRazonSocial(),
                socioNegocio.getGenero(),
                socioNegocio.getCodigoTipoSocioNegocio()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody SocioNegocio socioNegocio){
        socioNegocioRepository.spUpdateSocio(
                socioNegocio.getCodigoSocio(),
                socioNegocio.getPrimerNombre(),
                socioNegocio.getSegundoNombre(),
                socioNegocio.getPrimerApellido(),
                socioNegocio.getSegundoApellido(),
                socioNegocio.getFechaNacimiento(),
                socioNegocio.getCUI(),
                socioNegocio.getNIT(),
                socioNegocio.getRazonSocial(),
                socioNegocio.getGenero(),
                socioNegocio.getCodigoTipoSocioNegocio()
        );
    }

    @DeleteMapping("/{codigoSocioNegocio}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoSocioNegocio){
        socioNegocioRepository.spDeleteSocio(codigoSocioNegocio);
    }
}
