package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoAsistenciaRepository extends JpaRepository<TipoAsistencia, Integer> {
    //    CodigoTipoAsistencia (smallint, PK)
    //    Descripcion (varchar(60))
    @Procedure
    List<TipoAsistencia> spReadTiposAsistencia();

    @Procedure
    void spCreateTipoAsistencia(Integer CodigoTipoAsistencia, String descripcion);

    @Procedure
    void spUpdateTipoAsistencia(Integer CodigoTipoAsistencia, String descripcion);

    @Procedure
    void spDeleteTipoAsistencia(Integer CodigoTipoAsistencia);
}
