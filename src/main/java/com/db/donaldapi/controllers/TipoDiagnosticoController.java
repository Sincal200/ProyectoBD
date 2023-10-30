package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoDiagnostico;
import com.db.donaldapi.repositories.TipoDiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposDiagnostico")
public class TipoDiagnosticoController {

    private final TipoDiagnosticoRepository tipoDiagnosticoRepository;

    @Autowired
    public TipoDiagnosticoController(TipoDiagnosticoRepository tipoDiagnosticoRepository) {
        this.tipoDiagnosticoRepository = tipoDiagnosticoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoDiagnostico> findAll(){
        return tipoDiagnosticoRepository.spReadTiposDiagnostico();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoDiagnostico tipoDiagnostico){
        tipoDiagnosticoRepository.spCreateTipoDiagnostico(
                tipoDiagnostico.getCodigoDiagnostico(),
                tipoDiagnostico.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoDiagnostico tipoDiagnostico){
        tipoDiagnosticoRepository.spUpdateTipoDiagnostico(
                tipoDiagnostico.getCodigoDiagnostico(),
                tipoDiagnostico.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoDiagnostico}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoDiagnostico){
        tipoDiagnosticoRepository.spDeleteTipoDiagnostico(codigoDiagnostico);
    }
}
