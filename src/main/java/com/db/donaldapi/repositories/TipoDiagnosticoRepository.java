package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.TipoDiagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoDiagnosticoRepository extends JpaRepository<TipoDiagnostico, Integer> {
//    CodigoDiagnostico (int, PK)
//    Descripcion (varchar(60))
    @Procedure
    List<TipoDiagnostico> spReadTiposDiagnostico();

    @Procedure
    void spCreateTipoDiagnostico(Integer CodigoDiagnostico, String descripcion);

    @Procedure
    void spUpdateTipoDiagnostico(Integer CodigoDiagnostico, String descripcion);

    @Procedure
    void spDeleteTipoDiagnostico(Integer CodigoDiagnostico);
}
