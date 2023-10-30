package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoDireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoDireccionRepository extends JpaRepository<TipoDireccion, Integer> {
    //    CodigoTipoDireccion (smallint, PK)
    //    Descripcion (varchar(64))
    @Procedure
    List<TipoDireccion> spReadTiposDireccion();

    @Procedure
    void spCreateTipoDireccion(Integer CodigoTipoDireccion, String descripcion);

    @Procedure
    void spUpdateTipoDireccion(Integer CodigoTipoDireccion, String descripcion);

    @Procedure
    void spDeleteTipoDireccion(Integer CodigoTipoDireccion);
}
