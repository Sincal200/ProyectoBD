package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.MunicipioDto;
import com.db.donaldapi.models.entities.Municipio;
import com.db.donaldapi.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    private final MunicipioRepository municipioRepository;

    @Autowired
    public MunicipioController(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Municipio> findAll(){
        return municipioRepository.usp_GetMunicipios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody MunicipioDto municipioDto){
        municipioRepository.usp_CreateMunicipio(
                municipioDto.getCodigoMunicipio(),
                municipioDto.getDepartamentoCodigo(),
                municipioDto.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody MunicipioDto  municipioDto){
        municipioRepository.usp_UpdateMunicipio(
                municipioDto.getCodigoMunicipio(),
                municipioDto.getDepartamentoCodigo(),
                municipioDto.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoDepartamento}/{codigoMunicipio}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoDepartamento,
                            @PathVariable Integer codigoMunicipio){
        municipioRepository.usp_DeleteMunicipio(
                codigoMunicipio,
                codigoDepartamento
        );
    }
}
