package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.UpdateCitaDto;
import com.db.donaldapi.models.entities.Cita;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @GetMapping("/{numeroCita}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public Cita findById(@PathVariable Integer numeroCita){
        return citaRepository.sp_LeerCita(numeroCita);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Cita cita){
        citaRepository.sp_CrearCita(
                cita.getNumeroCita(),
                cita.getCodigoSucursal(),
                cita.getCodigoCliente(),
                cita.getFechaCita(),
                cita.getFechaRecepcion(),
                cita.getObservaciones(),
                cita.getCodigoEmpleado(),
                cita.getCodigoAutomovil()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody UpdateCitaDto cita){
        citaRepository.sp_ActualizarCita(
                cita.getNumeroCita(),
                cita.getObservaciones()
        );
    }

    @DeleteMapping("/{numeroCita}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer numeroCita){
        citaRepository.sp_EliminarCita(numeroCita);
    }
}
