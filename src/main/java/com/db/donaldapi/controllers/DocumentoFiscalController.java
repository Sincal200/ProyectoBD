package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.DocumentoFiscal;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.DocumentoFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentosFiscales")
public class DocumentoFiscalController {

    private final DocumentoFiscalRepository documentoFiscalRepository;

    @Autowired
    public DocumentoFiscalController(DocumentoFiscalRepository documentoFiscalRepository) {
        this.documentoFiscalRepository = documentoFiscalRepository;
    }


    @GetMapping("/{codigoTipoDocumentoFiscal}/{serie}/{numero}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public DocumentoFiscal find(@PathVariable Integer codigoTipoDocumentoFiscal,
                                @PathVariable String serie,
                                @PathVariable Integer numero){
        return documentoFiscalRepository.spLeerDocumentoFiscal(
                codigoTipoDocumentoFiscal,
                serie,
                numero
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody DocumentoFiscal documentoFiscal){
        documentoFiscalRepository.spCrearDocumentoFiscal(
                documentoFiscal.getCodigoTipoDocumentoFiscal(),
                documentoFiscal.getSerie(),
                documentoFiscal.getNumero(),
                documentoFiscal.getFechaEmision().toString(),
                documentoFiscal.getNIT(),
                documentoFiscal.getValorTotal(),
                documentoFiscal.getIVA(),
                documentoFiscal.getEstado()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody DocumentoFiscal documentoFiscal){
        documentoFiscalRepository.spActualizarDocumentoFiscal(
                documentoFiscal.getCodigoTipoDocumentoFiscal(),
                documentoFiscal.getSerie(),
                documentoFiscal.getNumero(),
                documentoFiscal.getFechaEmision().toString(),
                documentoFiscal.getNIT(),
                documentoFiscal.getValorTotal(),
                documentoFiscal.getIVA(),
                documentoFiscal.getEstado()
        );
    }

    @DeleteMapping("/{codigoTipoDocumentoFiscal}/{serie}/{numero}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoTipoDocumentoFiscal,
                           @PathVariable String serie,
                           @PathVariable Integer numero){
        documentoFiscalRepository.spBorrarDocumentoFiscal(
                codigoTipoDocumentoFiscal,
                serie,
                numero);
    }
}
