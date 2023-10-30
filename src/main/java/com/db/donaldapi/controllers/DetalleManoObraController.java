package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateDetalleManoObraDto;
import com.db.donaldapi.models.entities.DetalleManoObra;
import com.db.donaldapi.repositories.DetalleManoObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesManoObra")
public class DetalleManoObraController {

    private final DetalleManoObraRepository detalleManoObraRepository;

    @Autowired
    public DetalleManoObraController(DetalleManoObraRepository detalleManoObraRepository) {
        this.detalleManoObraRepository = detalleManoObraRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<DetalleManoObra> findAll(){
        return detalleManoObraRepository.sp_leer_detalles_mano_obra();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody DetalleManoObra detalleManoObra){
        detalleManoObraRepository.sp_insertar_detalle_mano_obra(
                detalleManoObra.getNumeroOrden(),
                detalleManoObra.getNumeroManoDeObra(),
                detalleManoObra.getUnidades(),
                detalleManoObra.getCodigoManoObra(),
                detalleManoObra.getFechaInicio(),
                detalleManoObra.getFechaFin(),
                detalleManoObra.getCodigoEmpleado(),
                detalleManoObra.getSerie(),
                detalleManoObra.getNumero(),
                detalleManoObra.getCodigoTipoDocumentoFiscal()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateDetalleManoObraDto detalleManoObra){
        detalleManoObraRepository.sp_actualizar_detalle_mano_obra(
                detalleManoObra.getNumeroOrden(),
                detalleManoObra.getNumeroManoDeObra(),
                detalleManoObra.getUnidades(),
                detalleManoObra.getCodigoManoObra(),
                detalleManoObra.getFechaFin()
        );
    }

    @DeleteMapping("/{numeroOrden}/{numeroManoDeObra}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroOrden, @PathVariable Integer numeroManoDeObra){
        detalleManoObraRepository.sp_eliminar_detalle_mano_obra(numeroOrden, numeroManoDeObra);
    }
}
