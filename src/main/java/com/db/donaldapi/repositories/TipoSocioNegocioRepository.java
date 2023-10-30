package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoSocioNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoSocioNegocioRepository extends JpaRepository<TipoSocioNegocio, Integer> {
    //    CodigoTipoSocioNegocio (int, PK)
    //    Descripcion (varchar(30)
    //    EsPersona (bit)
    @Procedure
    List<TipoSocioNegocio> spReadTiposSocioNegocio();

    @Procedure
    void spCreateTipoSocioNegocio(Integer codigoTipoSocioNegocio,
                                  String descripcion,
                                  Boolean esPersona);

    @Procedure
    void spUpdateTipoSocioNegocio(Integer codigoTipoSocioNegocio,
                                  String descripcion,
                                  Boolean esPersona);

    @Procedure
    void spDeleteTipoSocioNegocio(Integer codigoTipoSocioNegocio);
}
