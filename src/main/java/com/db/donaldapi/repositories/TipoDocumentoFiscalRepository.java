package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoDocumentoFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoDocumentoFiscalRepository extends JpaRepository<TipoDocumentoFiscal, Integer> {
    //    CodigoTipoDocumentoFiscal (int, PK)
    //    Descripcion (varchar(50))
    @Procedure
    List<TipoDocumentoFiscal> spReadTiposDocumentoFiscal();

    @Procedure
    void spCreateTipoDocumentoFiscal(Integer CodigoTipoDocumentoFiscal, String descripcion);

    @Procedure
    void spUpdateTipoDocumentoFiscal(Integer CodigoTipoDocumentoFiscal, String descripcion);

    @Procedure
    void spDeleteTipoDocumentoFiscal(Integer CodigoTipoDocumentoFiscal);
}
