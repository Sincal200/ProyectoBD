package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateDetalleMovimientoMaterialDto;
import com.db.donaldapi.models.entities.DetalleMovimientoMaterial;
import com.db.donaldapi.repositories.DetalleMovimientoMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesMovimientoMaterial")
public class DetalleMovimientoMaterialController {

    private final DetalleMovimientoMaterialRepository detalleMovimientoMaterialRepository;

    @Autowired
    public DetalleMovimientoMaterialController(DetalleMovimientoMaterialRepository detalleMovimientoMaterialRepository) {
        this.detalleMovimientoMaterialRepository = detalleMovimientoMaterialRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<DetalleMovimientoMaterial> findAll(){
        return detalleMovimientoMaterialRepository.sp_leer_detalles_movimientos_material();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody DetalleMovimientoMaterial detalleMovimientoMaterial){
        detalleMovimientoMaterialRepository.sp_insertar_detalle_movimiento_material(
                detalleMovimientoMaterial.getNumeroMovimiento(),
                detalleMovimientoMaterial.getCodigoMaterial(),
                detalleMovimientoMaterial.getLineaDetalleMovimiento(),
                detalleMovimientoMaterial.getUnidades()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateDetalleMovimientoMaterialDto detalleMovimientoMaterial){
        detalleMovimientoMaterialRepository.sp_actualizar_detalle_movimiento_material(
                detalleMovimientoMaterial.getNumeroMovimiento(),
                detalleMovimientoMaterial.getLineaDetalleMovimiento(),
                detalleMovimientoMaterial.getUnidades()
        );
    }

    @DeleteMapping("/{numeroMovimiento}/{lineaDetalleMovimiento}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroMovimiento, @PathVariable Integer lineaDetalleMovimiento){
        detalleMovimientoMaterialRepository.sp_eliminar_detalle_movimiento_material(
                numeroMovimiento,
                lineaDetalleMovimiento
        );
    }
}
