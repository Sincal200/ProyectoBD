package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.DocumentoFiscal;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface DocumentoFiscalRepository extends JpaRepository<DocumentoFiscal, Integer> {
    @Procedure
    DocumentoFiscal spLeerDocumentoFiscal(Integer codigoTipoDocumentoFiscal,
                                          String serie,
                                          Integer numero);

    @Procedure
    void spCrearDocumentoFiscal(Integer codigoTipoDocumentoFiscal,
                                String serie,
                                Integer numero,
                                String fechaEmision,
                                String nit,
                                Double valorTotal,
                                Double iva,
                                String estado);

    @Procedure
    void spActualizarDocumentoFiscal(Integer codigoTipoDocumentoFiscal,
                                     String serie,
                                     Integer numero,
                                     String fechaEmision,
                                     String nit,
                                     Double valorTotal,
                                     Double iva,
                                     String estado);

    @Procedure
    void spBorrarDocumentoFiscal(Integer codigoTipoDocumentoFiscal,
                         String serie,
                         Integer numero);
}
