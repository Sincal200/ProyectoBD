package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoDocumentoFiscal;
import com.db.donaldapi.repositories.TipoDocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposDocumentFiscal")
public class TipoDocumentoFiscalController {

    private final TipoDocumentoFiscalRepository tipoDocumentoFiscalRepository;

    @Autowired
    public TipoDocumentoFiscalController(TipoDocumentoFiscalRepository tipoDocumentoFiscalRepository) {
        this.tipoDocumentoFiscalRepository = tipoDocumentoFiscalRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<TipoDocumentoFiscal> findAll(){
        return tipoDocumentoFiscalRepository.spReadTiposDocumentoFiscal();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody TipoDocumentoFiscal tipoDocumentoFiscal){
        tipoDocumentoFiscalRepository.spCreateTipoDocumentoFiscal(
                tipoDocumentoFiscal.getCodigoTipoDocumentoFiscal(),
                tipoDocumentoFiscal.getDescripcion()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody TipoDocumentoFiscal tipoDocumentoFiscal){
        tipoDocumentoFiscalRepository.spUpdateTipoDocumentoFiscal(
                tipoDocumentoFiscal.getCodigoTipoDocumentoFiscal(),
                tipoDocumentoFiscal.getDescripcion()
        );
    }

    @DeleteMapping("/{codigoTipoDocumentoFiscal}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoDocumentoFiscal){
        tipoDocumentoFiscalRepository.spDeleteTipoDocumentoFiscal(codigoTipoDocumentoFiscal);
    }
}
