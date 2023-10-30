package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Bodega;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodegas")
public class BodegaController {

    private final BodegaRepository bodegaRepository;

    @Autowired
    public BodegaController(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }


    @GetMapping("/{codigoSucursal}/{codigoBodega}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public Bodega find(@PathVariable Integer codigoSucursal,
                       @PathVariable Integer codigoBodega){
        return bodegaRepository.sp_LeerBodega(
                codigoSucursal,
                codigoBodega
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Bodega bodega){
        bodegaRepository.sp_CrearBodega(
                bodega.getCodigoSucursal(),
                bodega.getCodigoBodega(),
                bodega.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Bodega bodega){
        bodegaRepository.sp_ActualizarBodega(
                bodega.getCodigoSucursal(),
                bodega.getCodigoBodega(),
                bodega.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoSucursal}/{codigoBodega}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoSucursal,
                           @PathVariable Integer codigoBodega){
        bodegaRepository.sp_EliminarBodega(
                codigoSucursal,
                codigoBodega
        );
    }
}
