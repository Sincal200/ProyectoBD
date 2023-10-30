package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Sucursal;
import com.db.donaldapi.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalController(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Sucursal> findAll(){
        return sucursalRepository.spReadSucursales();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Sucursal sucursal){
        sucursalRepository.spCreateSucursal(
                sucursal.getCodigoSucursal(),
                sucursal.getNombreSucursal(),
                sucursal.getCodigoTaller()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Sucursal sucursal){
        sucursalRepository.spUpdateSucursal(
                sucursal.getCodigoSucursal(),
                sucursal.getNombreSucursal(),
                sucursal.getCodigoTaller()
        );
    }

    @DeleteMapping("/{codigoSucursal}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoSucursal){
        sucursalRepository.spDeleteSucursal(codigoSucursal);
    }
}
