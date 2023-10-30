package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoPago;
import com.db.donaldapi.repositories.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposPago")
public class TipoPagoController {

    private final TipoPagoRepository tipoPagoRepository;

    @Autowired
    public TipoPagoController(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoPago> findAll(){
        return tipoPagoRepository.spReadTiposPago();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoPago tipoPago){
        tipoPagoRepository.spCreateTipoPago(
                tipoPago.getCodigoTipoPago(),
                tipoPago.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoPago tipoPago){
        tipoPagoRepository.spUpdateTipoPago(
                tipoPago.getCodigoTipoPago(),
                tipoPago.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoTipoPago}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoPago){
        tipoPagoRepository.spDeleteTipoPago(codigoTipoPago);
    }
}
