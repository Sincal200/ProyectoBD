package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateDetalleNominaDto;
import com.db.donaldapi.models.entities.DetalleNomina;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.DetalleNominaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesNomina")
public class DetalleNominaController {

    private final DetalleNominaRepository detalleNominaRepository;

    @Autowired
    public DetalleNominaController(DetalleNominaRepository detalleNominaRepository) {
        this.detalleNominaRepository = detalleNominaRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<DetalleNomina> findAll(){
        return detalleNominaRepository.sp_leer_detalles_nomina();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody DetalleNomina detalleNomina){
        detalleNominaRepository.sp_insertar_detalle_nomina(
                detalleNomina.getCodigoNomina(),
                detalleNomina.getNumeroDetalleNomina(),
                detalleNomina.getCodigoTipoMovimientoNomina(),
                detalleNomina.getValor(),
                detalleNomina.getCodigoEmpleado(),
                detalleNomina.getCodigoSucursal()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateDetalleNominaDto detalleNomina){
        detalleNominaRepository.sp_actualizar_detalle_nomina(
                detalleNomina.getCodigoNomina(),
                detalleNomina.getNumeroDetalleNomina(),
                detalleNomina.getValor()
        );
    }

    @DeleteMapping("/{codigoNomina}/{numeroDetalleNomina}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoNomina,
                           @PathVariable Integer numeroDetalleNomina){
        detalleNominaRepository.sp_eliminar_detalle_nomina(codigoNomina, numeroDetalleNomina);
    }
}
