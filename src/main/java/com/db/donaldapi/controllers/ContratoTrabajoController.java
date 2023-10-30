package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateContratoTrabajoDto;
import com.db.donaldapi.models.entities.ContratoTrabajo;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.ContratoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratosTrabajo")
public class ContratoTrabajoController {

    private final ContratoTrabajoRepository contratoTrabajoRepository;

    @Autowired
    public ContratoTrabajoController(ContratoTrabajoRepository contratoTrabajoRepository) {
        this.contratoTrabajoRepository = contratoTrabajoRepository;
    }


    @GetMapping("/{numeroContrato}/{codigoTaller}/{codigoEmpleado}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public ContratoTrabajo find(@PathVariable Integer numeroContrato,
                                @PathVariable Integer codigoTaller,
                                @PathVariable Integer codigoEmpleado){
        return contratoTrabajoRepository.sp_LeerContratoTrabajo(
                numeroContrato,
                codigoTaller,
                codigoEmpleado
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody ContratoTrabajo contratoTrabajo){
        contratoTrabajoRepository.sp_CrearContratoTrabajo(
                contratoTrabajo.getFechaEmision(),
                contratoTrabajo.getEstado(),
                contratoTrabajo.getCodigoTaller(),
                contratoTrabajo.getCodigoEmpleado(),
                contratoTrabajo.getNumeroContrato(),
                contratoTrabajo.getCodigoDepartamentoTrabajo(),
                contratoTrabajo.getCodigoPuestoTrabajo()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateContratoTrabajoDto contratoTrabajo){
        contratoTrabajoRepository.sp_ActualizarContratoTrabajo(
                contratoTrabajo.getNumeroContrato(),
                contratoTrabajo.getCodigoTaller(),
                contratoTrabajo.getCodigoEmpleado(),
                contratoTrabajo.getEstado()
        );
    }

    @DeleteMapping("/{numeroContrato}/{codigoTaller}/{codigoEmpleado}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroContrato,
                           @PathVariable Integer codigoTaller,
                           @PathVariable Integer codigoEmpleado){
        contratoTrabajoRepository.sp_EliminarContratoTrabajo(
                numeroContrato,
                codigoTaller,
                codigoEmpleado);
    }
}
