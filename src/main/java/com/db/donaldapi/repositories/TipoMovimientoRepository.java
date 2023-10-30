package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.TipoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento, Integer> {
    //    CodigoTipoMovimiento (int, PK)
    //    Descripcion (varchar(60))
    //    Naturaleza (tinyint)
    @Procedure
    List<TipoMovimiento> spReadTiposMovimiento();

    @Procedure
    void spCreateTipoMovimiento(Integer codigoTipoMovimiento,
                                String descripcion,
                                Integer naturaleza);

    @Procedure
    void spUpdateTipoMovimiento(Integer codigoTipoMovimiento,
                                 String descripcion,
                                 Integer naturaleza);

    @Procedure
    void spDeleteTipoMovimiento(Integer codigoTipoMovimiento);
}
