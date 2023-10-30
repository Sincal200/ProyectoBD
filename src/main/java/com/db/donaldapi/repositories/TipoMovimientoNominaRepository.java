package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoMovimientoNomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoMovimientoNominaRepository extends JpaRepository<TipoMovimientoNomina, Integer> {
    //    CodigoTipoMovimientoNomina (smallint, PK)
    //    Descripcion (varchar(128))
    //    Naturaleza (smallint)
    //    AfectoIGSS (bit)
    //    AfectoISR (bit)
    @Procedure
    List<TipoMovimientoNomina> spReadTiposMovimientoNomina();

    @Procedure
    void spCreateTipoMovimientoNomina(Integer codigoTipoMovimientoNomina,
                                      String descripcion,
                                      Integer naturaleza,
                                      Boolean afectoIGSS,
                                      Boolean afectoISR);

    @Procedure
    void spUpdateTipoMovimientoNomina(Integer codigoTipoMovimientoNomina,
                                      String descripcion,
                                      Integer naturaleza,
                                      Boolean afectoIGSS,
                                      Boolean afectoISR);

    @Procedure
    void spDeleteTipoMovimientoNomina(Integer codigoTipoMovimientoNomina);
}
