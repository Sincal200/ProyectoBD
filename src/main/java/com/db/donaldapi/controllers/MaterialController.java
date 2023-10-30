package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Material;
import com.db.donaldapi.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Material> findAll(){
        return materialRepository.usp_GetMateriales();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Material material){
        materialRepository.usp_CreateMaterial(
                material.getCodigoMaterial(),
                material.getDescripcion(),
                material.getPrecioVenta(),
                material.getPrecioCosto(),
                material.getSaldo()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Material material){
        materialRepository.usp_UpdateMaterial(
                material.getCodigoMaterial(),
                material.getDescripcion(),
                material.getPrecioVenta(),
                material.getPrecioCosto(),
                material.getSaldo()
        );
    }

    @DeleteMapping("/{codigoMaterial}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoMaterial){
        materialRepository.usp_DeleteMaterial(codigoMaterial);
    }
}
