package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateCotizacionDto;
import com.db.donaldapi.models.entities.Cotizacion;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.CotizaciónRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionController {

    private final CotizaciónRepository cotizaciónRepository;

    @Autowired
    public CotizacionController(CotizaciónRepository cotizaciónRepository) {
        this.cotizaciónRepository = cotizaciónRepository;
    }

    @GetMapping("/{numeroRequisicion}/{numeroCotizacion}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public Cotizacion find(@PathVariable Integer numeroRequisicion,
                           @PathVariable Integer numeroCotizacion){
        return cotizaciónRepository.sp_LeerCotizacion(
                numeroRequisicion,
                numeroCotizacion
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Cotizacion cotizacion){
        cotizaciónRepository.sp_CrearCotizacion(
                cotizacion.getNumeroRequisicion(),
                cotizacion.getNumeroCotizacion(),
                cotizacion.getFechaCotizacion(),
                cotizacion.getCodigoProveedor()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateCotizacionDto cotizacion){
        cotizaciónRepository.sp_ActualizarCotizacion(
                cotizacion.getNumeroRequisicion(),
                cotizacion.getNumeroCotizacion(),
                cotizacion.getFechaCotizacion()
        );
    }

    @DeleteMapping("/{numeroRequisicion}/{numeroCotizacion}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroRequisicion,
                           @PathVariable Integer numeroCotizacion){
        cotizaciónRepository.sp_EliminarCotizacion(
                numeroRequisicion,
                numeroCotizacion
        );
    }
}
