package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateDetalleMaterial;
import com.db.donaldapi.models.entities.DetalleMaterial;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.DetalleMaterialRepository;
import com.db.donaldapi.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesMaterial")
public class DetalleMaterialController {

    private final DetalleMaterialRepository detalleMaterialRepository;

    @Autowired
    public DetalleMaterialController(DetalleMaterialRepository detalleMaterialRepository) {
        this.detalleMaterialRepository = detalleMaterialRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<DetalleMaterial> findAll(){
        return detalleMaterialRepository.sp_leer_detalles_material();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody DetalleMaterial detalleMaterial){
        detalleMaterialRepository.sp_insertar_detalle_material(
                detalleMaterial.getNumeroOrden(),
                detalleMaterial.getNumeroManoDeObra(),
                detalleMaterial.getCodigoMaterial(),
                detalleMaterial.getNumeroDetalleMaterial(),
                detalleMaterial.getUnidades(),
                detalleMaterial.getPrecioVenta()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateDetalleMaterial detalleMaterial){
        detalleMaterialRepository.sp_actualizar_detalle_material(
                detalleMaterial.getNumeroOrden(),
                detalleMaterial.getNumeroManoDeObra(),
                detalleMaterial.getNumeroDetalleMaterial(),
                detalleMaterial.getUnidades(),
                detalleMaterial.getPrecioVenta()
        );
    }

    @DeleteMapping("/{numeroOrden}/{numeroManoDeObra}/{numeroDetalleMaterial}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroOrden,
                           @PathVariable Integer numeroManoDeObra,
                           @PathVariable Integer numeroDetalleMaterial){
        detalleMaterialRepository.sp_eliminar_detalle_material(
                numeroOrden,
                numeroManoDeObra,
                numeroDetalleMaterial
        );
    }
}
