package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateAsistenciaDto;
import com.db.donaldapi.models.entities.Asistencia;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    private final AsistenciaRepository asistenciaRepository;

    @Autowired
    public AsistenciaController(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }



    @GetMapping("/{correlativoAsistencia}/{codigoEmpleado}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public Asistencia find(@PathVariable Integer correlativoAsistencia,
                           @PathVariable Integer codigoEmpleado){
        return asistenciaRepository.sp_LeerAsistencia(
                correlativoAsistencia,
                codigoEmpleado
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Asistencia asistencia){
        asistenciaRepository.sp_CrearAsistencia(
                asistencia.getCorrelativoAsistencia(),
                asistencia.getCodigoEmpleado(),
                asistencia.getCodigoTipoAsistencia(),
                asistencia.getFechaIngreso(),
                asistencia.getFechaEgreso(),
                asistencia.getOrigen()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateAsistenciaDto asistencia){
        asistenciaRepository.sp_ActualizarAsistencia(
                asistencia.getCorrelativoAsistencia(),
                asistencia.getCodigoEmpleado(),
                asistencia.getFechaEgreso()
        );
    }

    @DeleteMapping("/{correlativoAsistencia}/{codigoEmpleado}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer correlativoAsistencia,
                           @PathVariable Integer codigoEmpleado){
        asistenciaRepository.sp_BorrarAsistencia(
                correlativoAsistencia,
                codigoEmpleado);
    }
}
