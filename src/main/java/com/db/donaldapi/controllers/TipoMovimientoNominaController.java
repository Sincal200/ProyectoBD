package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoMovimientoNomina;
import com.db.donaldapi.repositories.TipoMovimientoNominaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposMovimientoNomina")
public class TipoMovimientoNominaController {

    private final TipoMovimientoNominaRepository tipoMovimientoNominaRepository;

    @Autowired
    public TipoMovimientoNominaController(TipoMovimientoNominaRepository tipoMovimientoNominaRepository) {
        this.tipoMovimientoNominaRepository = tipoMovimientoNominaRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoMovimientoNomina> findAll(){
        return tipoMovimientoNominaRepository.spReadTiposMovimientoNomina();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoMovimientoNomina tipoMovimientoNomina){
        tipoMovimientoNominaRepository.spCreateTipoMovimientoNomina(
                tipoMovimientoNomina.getCodigoTipoMovimientoNomina(),
                tipoMovimientoNomina.getDescripcion(),
                tipoMovimientoNomina.getNaturaleza(),
                tipoMovimientoNomina.getAfectoIGSS(),
                tipoMovimientoNomina.getAfectoISR()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoMovimientoNomina tipoMovimientoNomina){
        tipoMovimientoNominaRepository.spUpdateTipoMovimientoNomina(
                tipoMovimientoNomina.getCodigoTipoMovimientoNomina(),
                tipoMovimientoNomina.getDescripcion(),
                tipoMovimientoNomina.getNaturaleza(),
                tipoMovimientoNomina.getAfectoIGSS(),
                tipoMovimientoNomina.getAfectoISR()
        );
    }

    @DeleteMapping("/{codigoTipoMovimientoNomina}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoMovimientoNomina){
        tipoMovimientoNominaRepository.spDeleteTipoMovimientoNomina(codigoTipoMovimientoNomina);
    }
}
