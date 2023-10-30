package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Marca> findAll(){
        return marcaRepository.usp_GetMarcas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Marca marca){
        marcaRepository.usp_CreateMarca(
                marca.getCodigoMarca(),
                marca.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Marca marca){
        marcaRepository.usp_UpdateMarca(
                marca.getCodigoMarca(),
                marca.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoMarca}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoMarca){
        marcaRepository.usp_DeleteMarca(codigoMarca);
    }
}
