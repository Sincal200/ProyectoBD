package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Departamento;
import com.db.donaldapi.models.entities.ManoObra;
import com.db.donaldapi.repositories.ManoObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manoObra")
public class ManoObreaController {

    private final ManoObraRepository manoObraRepository;

    @Autowired
    public ManoObreaController(ManoObraRepository manoObraRepository) {
        this.manoObraRepository = manoObraRepository;
    }


    @GetMapping("/{codigoManoObra}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public ManoObra findById(@PathVariable Integer codigoManoObra){
        return manoObraRepository.spLeerManoObra(codigoManoObra);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody ManoObra manoObra){
        manoObraRepository.spCrearManoObra(
                manoObra.getCodigoManoObra(),
                manoObra.getDescripcion(),
                manoObra.getPrecio()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody ManoObra manoObra){
        manoObraRepository.spActualizarManoObra(
                manoObra.getCodigoManoObra(),
                manoObra.getDescripcion(),
                manoObra.getPrecio()
        );
    }

    @DeleteMapping("/{codigoManoObra}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoManoObra){
        manoObraRepository.spEliminarManoObra(codigoManoObra);
    }
}
