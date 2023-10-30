package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoDireccion;
import com.db.donaldapi.repositories.TipoDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposDireccion")
public class TipoDireccionController {

    private final TipoDireccionRepository tipoDireccionRepository;

    @Autowired
    public TipoDireccionController(TipoDireccionRepository tipoDireccionRepository) {
        this.tipoDireccionRepository = tipoDireccionRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoDireccion> findAll(){
        return tipoDireccionRepository.spReadTiposDireccion();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoDireccion tipoDireccion){
        tipoDireccionRepository.spCreateTipoDireccion(
                tipoDireccion.getCodigoTipoDireccion(),
                tipoDireccion.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoDireccion tipoDireccion){
        tipoDireccionRepository.spUpdateTipoDireccion(
                tipoDireccion.getCodigoTipoDireccion(),
                tipoDireccion.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoTipoDireccion}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoDireccion){
        tipoDireccionRepository.spDeleteTipoDireccion(codigoTipoDireccion);
    }
}
