package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoMovimiento;
import com.db.donaldapi.repositories.TipoMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposMovimiento")
public class TipoMovimientoController {

    private final TipoMovimientoRepository tipoMovimientoRepository;

    @Autowired
    public TipoMovimientoController(TipoMovimientoRepository tipoMovimientoRepository) {
        this.tipoMovimientoRepository = tipoMovimientoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoMovimiento> findAll(){
        return tipoMovimientoRepository.spReadTiposMovimiento();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoMovimiento tipoMovimiento){
        tipoMovimientoRepository.spCreateTipoMovimiento(
                tipoMovimiento.getCodigoTipoMovimiento(),
                tipoMovimiento.getDescripcion(),
                tipoMovimiento.getNaturaleza()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoMovimiento tipoMovimiento){
        tipoMovimientoRepository.spUpdateTipoMovimiento(
                tipoMovimiento.getCodigoTipoMovimiento(),
                tipoMovimiento.getDescripcion(),
                tipoMovimiento.getNaturaleza()
        );
    }

    @DeleteMapping("/{codigoTipoMovimiento}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoMovimiento){
        tipoMovimientoRepository.spDeleteTipoMovimiento(codigoTipoMovimiento);
    }
}
